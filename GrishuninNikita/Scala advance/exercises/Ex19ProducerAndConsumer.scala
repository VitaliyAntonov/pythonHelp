package exercises

object Ex19ProducerAndConsumer extends App {
  def work(n: Int): Unit = {
    val process = new Object

    (1 to n).foreach(i => new Thread(() => {
      process.synchronized {
        process.wait()
        println(s"thread")
      }
    }).start())

    // Thread для уведомления, который надо дописать
    println(s"Time to work!")
    (1 to n).foreach(i => new Thread(() => {
      process.synchronized {
        process.notify()
      }
    }).start())

  }
  work(2)
}
