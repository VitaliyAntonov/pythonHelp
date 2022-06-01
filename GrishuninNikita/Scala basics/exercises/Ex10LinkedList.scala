package exercises

import scala.annotation.tailrec

object Ex10LinkedList extends App {
  abstract class LogList {
    def last: String
    def previous: LogList
    def isEmpty: Boolean
    def all: String
    def add(msg: String): LogList
  }
  class Log(head: String, tail: LogList) extends LogList{
    override def add(msg: String): LogList = new Log(msg, this)
    override def previous: LogList = tail
    override def last: String = head
    override def all: String = {
      @tailrec
      def loop(head: String = head, tail: LogList = tail, acc: String = ""): String = {
        if(tail.isEmpty) s"$acc $head"
        else loop(tail.last, tail.previous, if (acc == "") head else s"$acc $head")
      }
      loop()
    }
    override def isEmpty: Boolean = false
  }

  object Empty extends LogList{
    override def add(msg: String): LogList = new Log(msg, Empty)
    override def previous = throw new NoSuchElementException
    override def last: String = throw new NoSuchElementException
    override def all: String = ""
    override def isEmpty: Boolean = true
  }
  val list = new Log("m1", new Log("m2", new Log("m3", new Log("m4", Empty))))
  println(list.all)
  println("" +"m1 m2 m3 m4")
}