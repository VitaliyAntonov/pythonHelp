package lectures

object TypeClasses {
  // Под классом типов подразумевается трейт, который требует указания типа,
  // для которого он описывает возможные действия с этим типом.
  // Цель класса типа - описать функционал для разных типов.
  // Класс типа выглядит следующим образом:
  // задается тип, внутри перечисляются действия применяемые к заданному типу
  // (сами действия будут описаны в объектах, которые будут расширять этот класс типа)
  trait MyTypeClassTemplate[T] {
    def action(value: T): String
  }

  trait Info {
    def info: String
  }

  case class Flight(from: String, to: String, flightTime: Int) extends Info {
    override def info: String = s"Flight from $from to $to takes $flightTime minutes"
  }

  Flight("Moscow", "NizhniyNovgorod", 70).info

  // Работать такое будет только для типов которые мы задали изначально
  // Одним из выходов является использование шаблонов, в которых производится обработка разныех типов для отображения в инфо на экране

  case class AirportStaff(name: String, s: String)

  case class User(n: String, s: String)

  object InfoPatterns {
    def info(value: Any) = value match {
      case AirportStaff(n, s) => ""
      case User(n, s) => ""
    }
  }

  // Недостатки такого подхода
  // безопасность типов - мы использовали тип Any для value, а значит, подать на вход можно что угодно
  // поддержка кода - при добавлении новой структуры данных придется каждый раз вносить изменения в код
  // ограниченный функционал для каждого представленного типа - например, для пользователя не предоставляется разграничение на зарегистрированного и не

  // Лучшим решением станет трейт с параметром типа
  trait InfoProvider[T] {
    def info(value: T): String
  }

  // Тогда можно будет создать вот такой объект
  case class Flight2(from: String, to: String, flightTime: Int)

  object UserInfo extends InfoProvider[Flight2] {
    def info(flight: Flight2): String =
      s"Flight from ${flight.from} to ${flight.to} takes ${flight.flightTime} minutes"
  }
  // И вызвать сможем вот так
  val flightMscNizN = Flight2("Moscow", "NizhniyNovgorod", 70)
  println(UserInfo.info(flightMscNizN))

  // В то же время будет возможно по-другому обработать информацию о рейсе для сотрудника
  object StaffInfo extends InfoProvider[Flight2] {
    def info(flight: Flight2): String =
      s"For staff only: Flight from ${flight.from}"
  }

  println(StaffInfo.info(flightMscNizN))

  // С таким подходом мы сможем обработать любые типы
  import java.util.Date
  object DateInfo extends InfoProvider[Date] {
    override def info(date: Date): String = s"Given date is ${date.toString}"
  }

  // Имплиситы и классы типов
  // Добавим объект-компаньон к трейту. Этот компаньон будет наряду с обычным значением типа Т получать имплисит.
  trait Converter[T] {
    def convert(value: T): String
  }

  object Converter {
    def convert[T](value: T)(implicit converter: Converter[T]): String =
      converter.convert(value)
  }
  // Тогда запустить можно
  object DoubleConverter extends Converter[Double] {
    override def convert(value: Double): String = s"converted value: $value"
  }
  println(Converter.convert(2.0)(DoubleConverter))
  // Чтобы не прописывать второй аргумент в скобках, достаточно добавить implicit в нужное место
  // implicit object DoubleConverter extends Converter[Double]
  // Альтернативой является комбинация apply и имплисита внутри объекта-компаньона
  // def apply[T](implicit converter: Converter[T]) = converter
  // Преимущество такого подхода - доступ ко всем методам, прописанным в классе типа.

  // Таким образом полный шаблон для класса типов выглядит вот так:
  trait MyTypeClassTemplat[T] {
    def action(value: T): String
  }

  object MyTypeClassTemplate {
    def apply[T](implicit instance: MyTypeClassTemplat[T]) = instance
  }

  // Pimp My Library паттерн
  // Иногда требуется дополнить уже существующие классы новыми методами.
  // Достигается это за счет создания имплиситных классов, на вход которым поступает один- единственный аргумент
  implicit class RichInt(value: Int) {
    def sqrt: Double = Math.sqrt(value)
  }

  println(new RichInt(16).sqrt)
  // Так как класс создан с ключевым словом implicit, сработает и такой вызов
  println(16.sqrt)
  // На практике (с целью оптимизации памяти) такие имплиситные классы принято создавать с extends AnyVal (тогда перед value должно стоять val)
  implicit class RichInt2(val value: Int) extends AnyVal {
    def sqrt2: Double = Math.sqrt(value)
  }

  // Magnet Pattern
  // Представим, что мы проектируем библиотеку для выполнения арифметических операций. Можно набросать вот такой код:
  trait MathLibrary {
    def increment(x: Int): Int = x + 1
    def increment(x: String): Int = x.toInt + 1
  }
  // Данный подход имеет несколько минусов:
  // при задании default-аргументов будет невозможно различить, какой из методов применять для increment():
  // лифтинг, требующийся для HOF - не сработает
  // по завершении компиляции происходит стирание типов, следовательно, станет невозможным различить методы между собой

  // Решением проблемы является реализация magnet pattern:
  trait MathMagnet {
    def apply(): Int
  }
  def increment(magnet: MathMagnet): Int = magnet() // вызываем apply
  // Один метод increment для всех случаев.
  // А функционал для разных типов задается через имплиситы, в которых детализируем apply() из MathMagnet
  implicit class IncrementInt (x: Int) extends MathMagnet {
    override def apply(): Int = x + 1
  }

  implicit class IncrementStr (x: String) extends MathMagnet {
    override def apply(): Int = x.toInt+ 1
  }

  println(increment("5")) // 6
  println(increment(7)) // 8

  // Сериализация данных, заданы следующие кейс классы:
  case class Customer(email: String, name: String)
  case class Item(id: Int, description: String)
  case class Order(customer: Customer, items: List[Item])
  // Тогда для данных:
  val customer = Customer("alice@mail.com", "Alice")
  val order = Order(customer, List(
    Item(1, "first item"),
    Item(2, "second item"),
  ))

  // Конечный результат сериализации должен выглядеть следующим образом
  // {"customer":{"email":"alice@mail.com","name":"Alice"},"items":[{"id":1,"description":"first item"},{"id":2,"description":"second item"}]}

}
