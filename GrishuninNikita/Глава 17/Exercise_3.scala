import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.DurationInt
import scala.concurrent.{Await, Future}

/**
 * Повторите предыдущее упражнение для произвольной последовательности функций типа T => Future[T].
 */
object Exercise_3 extends App{
  def doInOrder[T](f: (T=>Future[T])*): T=> Future[T] ={
    f.reduceLeft((a, b) => x => a(x) flatMap b)
  }
  def f(n: Int) = Future {n + 1}
  def g(n: Int) = Future {n * 2}
  def h (n: Int) = Future {n - 1}
  val b = Await.result((doInOrder(f, g, h)(5)), 10.seconds)
  println(b)
}
