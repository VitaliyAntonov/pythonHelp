package lectures

object ProducerAndConsumer2 extends App {
  // Имеем:
  // один производитель нескольких значений (их количество не превышает заданного максимального значения)
  // один потребитель значений
  // количество производимых значений ограничено каким-то числом
  // процессы бегут бесконечно
  // производитель может находиться в режиме ожидания (производитель не может произвести значений больше, чем ему позволено. Если буфер заполнен, производитель вынужден ждать, пока потребитель освободит место для следующих чисел)
  // потребитель может находиться в режиме ожидания (если буфер пуст, т.е. потребляет значения быстрее, чем те производятся)

  import scala.collection.mutable
  import scala.util.Random

  def work(): Unit = {
    val buffer: mutable.Queue[Int] = new mutable.Queue[Int]
    val capacity = 3 // допустимые размер буфера

    val consumer = new Thread(() => {
      val random = new Random()

      while (true) { // заставляем процессы бежать бескноечное
        buffer.synchronized { // синхронизация чтобы параллельные процессы одновременно изменяли буфер
          if (buffer.isEmpty) {
            println("потребитель: буфер пуст - ожидаю значений...")
            buffer.wait()
          }

          val x = buffer.dequeue() // начинаем потреблять как только в буфере доступно хотя бы одно значение
          println("потребитель: значение получено " + x)

          buffer.notify() // уведомляем что буфер пуст
        }

        Thread.sleep(random.nextInt(250))
      }
    })

    val producer = new Thread(() => {
      val random = new Random()
      var i = 0

      while (true) {
        buffer.synchronized {
          if (buffer.size == capacity) {
            println("производитель: буфер заполнен - ожидаю...")
            buffer.wait() // хотя бы одно место должно быть доступно в буфере для заполнения
          }

          println("производитель: предоставляю значение " + i)
          buffer.enqueue(i)

          buffer.notify() // информируем потребяителя о наличии значений в буфере

          i += 1
        }

        Thread.sleep(random.nextInt(500))
      }
    })

    consumer.start()
    producer.start()
  }

  work()
}
