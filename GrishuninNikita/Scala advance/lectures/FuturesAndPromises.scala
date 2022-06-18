package lectures

object FuturesAndPromises extends App {
  import scala.concurrent.{Future, Promise}
  import scala.util.Success
  import scala.concurrent._
  import ExecutionContext.Implicits.global

  val promise = Promise[String]() // promise - способ контролировать future
  val future = promise.future // указываем, что future находится под управлением promise

  val producer = new Thread(() => {
    Thread.sleep(100)
    promise.success("Produced String") // значение будет передано consumer'у
  })

  future.onComplete {
    case Success(v) => println("consumed:" + v) // consumer вызывается сразу после отработки producer'а
  }

  producer.start()
  Thread.sleep(500) // даем время на выполнение
}
