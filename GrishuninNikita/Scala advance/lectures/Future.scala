package lectures

object Future {
  // Если требуется организовать параллельные вычисления в действительно функциональном стиле - на помощь придут фьючерсы.
  // Для работы с ними потребуется следующий импорт:

  import scala.concurrent.Future
  import scala.concurrent.ExecutionContext.Implicits.global
  import scala.util.{Failure, Success}

  // Допустим, необходимо использовать фьючерсы для запуска какого-то долгого вычисления:
  def veryLongComputation: String = {
    Thread.sleep(1000)
    "Long Computation Done"
  }
  // Тогда организовать это можно следующим образом:

  //val aFuture = Future {
  //  veryLongComputation
  //} // именно здесь используется global имплисит

  // При получении значения Future через .value придется иметь дело с типом Option[Try[T]]:
  //aFuture.value
  // Try -  потому что вполне может возникнуть исключение
  // Option -  потому что в момент вызова .value у нас нет гарантии, что Future вычисления были полностью произведены

  // Поэтому гораздо целесообразнее будет получить значение только после завершения всех вычислений, указанных для Future:

  //aFuture.onComplete {
  //  case Success(result) => println(s"$result")
 //   case Failure(exception) => println(s"got an exception $exception")
 // }

  Thread.sleep(2000) // даем возможность Future произвести все вычисления

  // Два ключевых момента, которые стоит запомнить:
  // .onComplete возвращает Unit, так что его предназначение - side effects
  // нам неизвестно, какой именно Thread будет исполнять Future
}
object System {
  // Посмотрим, как Futures применяются на практике.
  // Займемся разработкой системы онлайн бронирования билетов.
  // Предварительно импортируем следующие модули:

  import scala.util.{Failure, Random, Success}
  import scala.concurrent.Future
  import scala.concurrent.ExecutionContext.Implicits.global

  // В реальности подобные системы не дают мгновенный ответ, так как какое-то количество времени требуется для проведения необходимых для выдачи ответа вычислений.
  // Сымитируем подобные вычисления посредством Random:

  val rdm = new Random()

  // Для поиска необходимого маршрута в сети создан класс FlightProfile:

  case class FlightProfile(id: String, city: String) {
    def search(destination: FlightProfile) =
      println(s"found flights from ${this.city} to ${destination.city}")
  }

  // Не будем сильно усложнять код, создадим простую Map-имитацию базы данных,
  // в которой будет храниться информация о доступных направлениях(id -> Наименование) и маршрутах (id -> id).

  object FlightNetwork {
    val sources = Map(
      "r1-msc" -> "Moscow",
      "r2-spb" -> "St Petersburg"
    )
    val routes = Map(
      "r1-msc" -> "r2-spb"
    )
    def fetchSource(id: String): Future[FlightProfile] = Future {
      Thread.sleep(rdm.nextInt(100)) // имитируем вычисления
      FlightProfile(id, sources(id))
    }

    def fetchDestination(profile: FlightProfile): Future[FlightProfile] = Future {
      Thread.sleep(rdm.nextInt(200))
      val destinationId = routes(profile.id)
      FlightProfile(destinationId, sources(destinationId))
    }
  }

  // Нет никакого смысла создавать несколько экземпляров для FlightNetwork,
  // поэтому для FlightNetwork используем object вместо класса (вы же помните, что объекты являются одиночками).

  // Сама работа с базой данных описывается вот так:

  // Посмотрим, как происходит поиск маршрута Москва - Питер на стороне клиента. Естественно, работать будем с Future.
  // Последовательность действий такова, что сначала мы производим fetchSource для города отправления,
  // затем (после того, как Future отработало) fetchDestination для города назначения:

  val sourceCity = FlightNetwork.fetchSource("r1-msc")

  sourceCity.onComplete {
    case Success(sourceProfile) => {
      val destination = FlightNetwork.fetchDestination(sourceProfile)

      destination.onComplete {
        case Success(destinationProfile) => sourceProfile.search(destinationProfile)
        case Failure(e) => e.printStackTrace()
      }

    }
    case Failure(ex) => ex.printStackTrace()
  }

  Thread.sleep(rdm.nextInt(800)) // даем Future время полностью отработать

  // Гораздо лучше при написании кода использовать функциональную композицию, что подразумевает применение map, flatMap, filter
  // map - трансформирует Future заданного типа в Future другого типа
  // flatMap - трансформирует заданное Future в другое Future такого же типа
  // filter - возвращает отфильтрованное значение или NoSuchElementException

  val source = FlightNetwork.fetchSource("r1-msc")
  val sourceCity2 = source.map(profile => profile.city) // получили тип Future[String]
  val destination = source.flatMap(profile => FlightNetwork.fetchDestination(profile))
  val destinationFiltered = destination.filter(profile => profile.city.startsWith("S"))

  // Fallback-механизм
  // Естественно, в нашей базе данных могут отсутствовать запрашиваемые значения.
  // Для таких случаев полезно будет воспользоваться recovery либо recoverWith:
  val unknownSource = FlightNetwork.fetchSource("unknown-id").recover {
    case e: Throwable => FlightProfile("r0-default", "Not Found")
  }

  // recoverWith пригодится, если захотим запросить другой профиль
  // (но тут следует учитывать, что этого другого профиля тоже может не оказаться):
  val someSource = FlightNetwork.fetchSource("unknown-id").recoverWith {
    case e: Throwable => FlightNetwork.fetchSource("r1-msc")
  }

  // Третий вариант - fallbackTo, когда вы получите результат запроса либо первого, либо второго указанного id:
  val fallbackResult =  FlightNetwork
    .fetchSource("unknown id")
    .fallbackTo(FlightNetwork.fetchSource("r0-default"))
}


