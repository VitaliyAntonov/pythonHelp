import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.DurationInt
import scala.concurrent.{Await, Future}

/**
 * Напишите функцию doTogether, принимающую функции f: T => Future[U] и g: U => Future[V]
 * и возвращающую функцию T => Future[(U, V)], которая выполняет два задания параллельно
 * и для заданного значения t в конечном счете возвращает (f(t), g(t)).
 */
object Exercise_4 extends App{
  def doTogether[T,U,V](f: T=> Future[U], g: T => Future[V]): T => Future[(U, V)] = {
    (t: T) => {
      val fRes = f(t)
      val gRes = g(t)
      fRes.flatMap(u => gRes.map(v=>(u, v)))
    }
  }
  def f(n: Int) = Future {n + 1}
  def g(n: Int) = Future {n * 2}
  val b = Await.result((doTogether(f, g)(5)), 10.seconds)
  println(b)
}
