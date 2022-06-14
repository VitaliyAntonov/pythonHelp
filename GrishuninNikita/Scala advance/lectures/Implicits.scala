package lectures

object Implicits extends App {
  // Имплиситы
  // Основное назначение имплиситов - устранение дублирования кода, когда несколько методов требуют передачи одних и тех же параметров или когда требуется конвертация типов.
  case class Course(title: String) {
    def info = s"This is $title course"

    def platform(implicit name: String) = s"Course platform: $name"
  }

  implicit def toCourse(title: String): Course = Course(title) // благодаря ключевому слову implicit мы может повзолить себе писать так: "Scala".info

  // На самом деле отрабатывает вот такой код: toCourse("Scala").info
  implicit val defaultPlatform = "Stepik" // В данном случае при вызове функции platform, автоматические подставиться переменная
  //  так как компилятор догадается подставить defaultPlatform
  //  отрабатывает код toCoutse("Scala").platform(defaultPlatform)
  // Также можно просто применить implicit для класса, и код также работал
  println("Scala".info)
  println("Scala".platform)

  // Компилятор ищет иплиситы в следующем порядке:
  // В локальной области видимости(т.е там, где код, требующий имплисита, написан)
  // в импортированных файлах
  // в объектах компаньонах

  // Организация имплиситов

  case class Courses(id: Int, title: String, nStud: Int)

  val courses = List(
    Courses(0, "Scala", 100),
    Courses(1, "Advanced Scala", 200),
    Courses(4, "Spark", 300),
    Courses(3, "Cats", 400)
  )
  // Нам надо предусмотреть различные варианты сортировки с помощью имплиситов.
  // Организовать код для этого можно разными способами, все зависит от поставленных задач

  // Если вам необходим только один имплисит, который должен всегда использоваться,
  // то его лучше объявить в объекте-компаньоне того типа, для которого предполагается сортировка.
  object Courses {
    implicit val defaultOrdering: Ordering[Courses] = Ordering.by(c => (c.nStud))
  }

  // если предполагается несколько имплиситных значений, однако только одно подходит
  // для большинства случаев и только его действительно предполагается применять,
  // то этот подходящий имплисит объявляем в объекте-компаньоне,
  // а остальные где-то вне его, предпочтительно в других объектах
  object idOrdering {
    implicit val defaultOrdering: Ordering[Courses] = Ordering.by(c => (c.id))
  }

  object titleOrdering {
    implicit val defaultOrdering: Ordering[Courses] = Ordering.by(c => (c.title))
  }
  // В этом случае сортировка все-равно будет происходить по количеству студентов (nStud),
  // а все из-за порядка, по которому ищутся имплиситы для применения.

  // если подходящих имплиситов несколько, то надо расфасовать их по отдельным контейнерам
  // или объектам и дать пользователю возможность импортировать нужный.
  // Пример:
  import idOrdering._
  println(courses.sorted)

}
