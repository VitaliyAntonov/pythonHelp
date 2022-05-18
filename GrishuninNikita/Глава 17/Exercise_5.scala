import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.DurationInt
import scala.concurrent.{Await, Future}

/**
 * Напишите функцию, принимающую последовательность объектов Future и возвращающую объект Future,
 * который в конечном счете возвращает последовательность всех результатов
 */
object Exercise_5 extends App{
  def func[T](f: Seq[Future[T]]): Future[Seq[T]] = {
    Future.sequence(f)
  }
}
