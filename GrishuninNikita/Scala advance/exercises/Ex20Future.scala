package exercises

object Ex20Future extends App {
  import scala.concurrent._
  import ExecutionContext.Implicits.global

  def firstToComplete[A](futureA: Future[A], futureB: Future[A]): Unit = {
    val promise = Promise[A]
    promise.future
    futureA.onComplete(promise.tryComplete)
    futureB.onComplete(promise.tryComplete)
  }

}
