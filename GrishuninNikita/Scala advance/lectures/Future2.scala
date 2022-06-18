package lectures

object Future2 extends App {
  // Await
  // Предназначение await - блокировать thread на заданный промежуток времени.

  //Обычно await рекомендуют избегать, делая выбор в пользу того же onComplete.
  // Причина - угроза возникновения deadlock-ов.
  // Однако await бывает иногда довольно полезен, особенно при тестировании,
  // так что мы не обойдем разбором и его.

  // Поработаем немного с процессом бронирования билетов. Нам понадобится:
  import scala.concurrent.{Await, Future, Promise}
  import scala.concurrent.duration._
  import scala.concurrent._
  import ExecutionContext.Implicits.global

  // Дополнительно создадим классы под пользователей и транзакции:
  case class User(name: String)
  case class Transaction(user: String, flight: String, status: String)

  object FlightNetwork {
    val users = Map(
      "u1-b" -> "Bob",
      "u2-a" -> "Alice"
    )

    val flight = "Msc - StP"

    def fetchUser(id: String): Future[User] = Future {
      Thread.sleep(100) // обычно получение данных из бд занимает время, что мы и отразили
      User(users(id))
    }

    def createTransaction(user: User, flight: String): Future[Transaction] = Future {
      Thread.sleep(200)
      // при желании - здесь можно дописать дополнительные проверки, например, на scam
      Transaction(user.name, flight, "SUCCESS")
    }


    // bookFlight возвращает статус транзакции в виде строки
    def bookFlight(userId: String, flight: String): String = {
      val transactionStatus = for {
        user <- fetchUser(userId)
        transaction <- createTransaction(user, flight)
      } yield transaction.status

      Await.result(transactionStatus, 1.seconds)
    }
  }
  // Await в качестве аргументов принимает:
  // Future, полного выполнения которого требуется дождаться время, в течение которого ожидается выполнение.
  // Если время ожидания вышло, будет получено исключение TimeoutException.
  println(FlightNetwork.bookFlight("u1-b", "Msc - StP")) // SUCCESS

}
