import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.DurationInt
import scala.concurrent.{Await, Future}

/**
 * Напишите функцию doInOrder, принимающую функции f: T => Future[U] и g: U => Future[V]
 * и возвращающую функцию T => Future[U], которая для заданного значения t в конечном счете возвращает g(f(t)).
 */
object Exercise_2 extends App{
  def doInOrder[T,U,V](f: T=>Future[U], g: U=>Future[V]): T=> Future[V] ={
    x=>f(x) flatMap g
  }
  def f(n: Int) = Future {n + 1}
  def g(n: Int) = Future {n * 2}
  val b = Await.result((doInOrder(f, g)(5)), 10.seconds)
  println(b)
}
