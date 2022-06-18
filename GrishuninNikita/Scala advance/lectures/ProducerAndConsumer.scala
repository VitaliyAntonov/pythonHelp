package lectures

object ProducerAndConsumer extends App {
  // Напишем программу с производителем и потребителем:
  class Container{
    private var num: Int = 0
    def isEmpty: Boolean = num == 0
    // производитель
    def set (newVal: Int) = num = newVal
    // потребитель
    def get = {
      val result = num
      num = 0
      result
    }
  }
  def work(): Unit = {
    val container = new Container
    val consumer = new Thread(() => {
      while (container.isEmpty){
        println("потребитель: ожидается значение...")

        container.synchronized{
          container.wait() // ждет сигнал от notify
        }
      }

      println("потребитель: значение получено " + container.get)
    })
    val producer = new Thread(() => {
      println("производитель: производятся вычисления...")
      // используем sleep для имитации каких-то вычислений
      Thread.sleep(500)

      val value = 12
      println("произвдитель: значение рассчитано " + value)
      container.set(value)
      container.notify()
    })
    consumer.start()
    producer.start()
  }
  work()
  // Для решения задачи, представленной на предыдущем шаге, в нашем распоряжении:
  //
  //notify - используется для уведомления какого-то одного процесса о наступлении события (какой именно процесс получит уведомление - заранее не известно)
  //notifyAll - уведомит все процессы, находящиеся в ожидании
  //wait - переводит процесс в режим ожидания, позволяет избежать бесполезных ожиданий в цикле while
  //wait и notify возможны только для выражений, прописанных внутри synchronized
}
