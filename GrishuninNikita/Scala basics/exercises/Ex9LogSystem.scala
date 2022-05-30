package exercises

import scala.annotation.tailrec

object Ex9LogSystem extends App {
  class Logger(val msgNum: Int = 0) {
    def info = {
      println(s"INFO New Message")
      new Logger(msgNum + 1)
    }
    def info(msgCount: Int) = {
      @tailrec
      def loop(msgCount: Int = msgCount, acc: Int = msgNum): Logger = {
        if (msgCount <= 0) this
        else {
          println("INFO New Message")
          loop(msgCount - 1, acc + 1)
        }
      }
      loop()
      new Logger(msgNum + msgCount)
    }
    def print : Unit = println(msgNum)
  }
  val msg = new Logger
  msg.info.info.info.print
}
