package exercises

import scala.annotation.tailrec

object Ex11GenericList extends App {
  abstract class LogList[+A] {
    def last: A
    def previous: LogList[A]
    def isEmpty: Boolean
    def all: String
    def add[B >: A](msg: B): LogList[B]
  }
  class Log[+A](head: A, tail: LogList[A]) extends LogList[A]{
    override def add[B >: A](msg: B): LogList[B] = new Log(msg, this)
    override def previous: LogList[A] = tail
    override def last: A = head
    override def all: String = {
      @tailrec
      def loop(head: A = head, tail: LogList[A] = tail): String = {
        if(tail.isEmpty) head
        else print(s"$head "); loop(tail.last, tail.previous)
      }
      loop()
    }
    override def isEmpty: Boolean = false
  }

  object Empty extends LogList[Nothing]{
    override def add[Nothing](msg: Nothing): LogList[Nothing] = new Log(msg, Empty)
    override def previous = throw new NoSuchElementException
    override def last: Nothing = throw new NoSuchElementException
    override def all: String = " "
    override def isEmpty: Boolean = true
  }
  //val list = new Log[Int](1, new Log[Float](2.0f, new Log[Double](3.0, Empty)))
  val intLogs: LogList[Int] = Empty
}
