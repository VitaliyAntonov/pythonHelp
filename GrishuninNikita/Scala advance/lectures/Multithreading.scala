package lectures

object Multithreading {
  // Применяется когда необходимо в программе запустить несколько процессов одновременно, каждый из которыйх занят выполнением своей задачи
  // Создать его можно следующим образом:
  val thread = new Thread {
    override def run {
      println("I run in parallel") // описываем желаемое поведение потока
    }
  }
  thread.start // сигнал на запуск потока

  // Аналогичным и более элегантным кодом будет:
  val runnable = new Runnable {
    override def run(): Unit = println("I run in parallel")
  }
  val thread2 = new Thread(runnable)
  thread2.start
  // В этом случае мы воспользовались классом Runnable и переопределили в нем метод run,
  // в котором прописали требуемое поведение потока.
  // Обычно так гораздо удобнее, так как мы не работаем с потоком напрямую, а пользуемся услугами Runnable.
  // Сделаем небольшое дополнение, отметив, что .start сам по себе не запускает нить, а посылает JVM сигнал о необходимости вызвать метод run() и запустить нить.
  // Кстати, можно сократить код еще больше, прописав run вот так
  val thread3 = new Thread(() => println("I run in parallel"))
  thread3.start()

  // Multi threads
  // Если мы объявили несколько нитей, то при многократном запуске программы окажется, что порядок их запуска вовсе не должен совпадать с порядком выполнения нитей.

  // Блокировка
  // Бывают ситуации, когда необходимо убедиться, что нить закончила выполнять все назначенные ей операции, и только потом продолжать вычисления.
  // Для этого предусмотрен .join()

  // Посмотрим пример, когда сначала отрабатывает первая нить, и только затем запускается вторая
  val firstThread = new Thread(() => (1 to 3).foreach(_ => println("1st thread: I run in parallel")))
  val secondThread = new Thread(() => (1 to 3).foreach(_ => println("2nd thread: I also run in parallel")))
  firstThread.start()
  firstThread.join()
  secondThread.start() // Начнется только после завершения предыдущего вызова .start

  // Пул
  // Создание нити является довольно дорогостоящей операцией, поэтому, создав нити один раз, лучше всего переиспользовать их, а не создавать новые под свои задачи.
  // Для этого и создается пул нитей

  import java.util.concurrent.Executors
  val pool = Executors.newFixedThreadPool(3) // указываем количество нитей, которые хотим переиспользовать

  // Плюсом пула является то, что нам нет никакой необходимости заботиться о запуске и остановке нитей, так что никаких .start(), только .execute()
  // Если мы больше не хотим использовать созданный пул, достаточно выполнить .shutdown():
  // Мы не сможем отправить в пул новые задачи, отправленные задачи будут выполнены
  pool.execute(runnable)
  pool.shutdown()
}
