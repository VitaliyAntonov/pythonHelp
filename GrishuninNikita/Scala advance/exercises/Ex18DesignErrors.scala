package exercises

object Ex18DesignErrors extends App {
  def runThreads(threadNum: Int, i: Int = 1): Thread = new Thread(() => {
    if (i < threadNum) {
      val thread = runThreads(threadNum, i + 1)
      thread.start()
      thread.join()
    }
    print(s"thread_$i ")
  })

  runThreads(3).start()
}
