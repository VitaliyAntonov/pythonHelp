package exercises

import scala.concurrent._
import ExecutionContext.Implicits.global

object test extends App{
  def firstFuture[T](value: T): Future[T] = Future(value)
  def secondFuture[T](value: T): Future[T] = Future(value)
  def inSequence[A, B](futureA: Future[A], futureB : Future[B]) : Unit ={
    futureA.flatMap(_ => futureB).foreach(f => println(f))
  }
}
