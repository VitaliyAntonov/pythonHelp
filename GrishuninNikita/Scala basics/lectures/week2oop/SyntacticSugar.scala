package lectures.week2oop

object SyntacticSugar extends App { // Синтаксический сахар это алтернативный способ написания кода, который напоминает естественный язык
  // Инфиксная нотация
  // Подходит только для методов с одним параметром
  class Person(val name: String, occupation: String) {
    def worksAs(jobName: String): Boolean = jobName == occupation
    def speaksEnglish: Boolean = true
    def &(person: Person): String = s"${this.name} and ${person.name} are colleagues" // Оператор & в качестве имени метода
    def unary_! : String = s"$name is not real" // unary_ можно использовать в качестве имени метода
    def apply(company : String): String = s"$name works as a $occupation in $company" // метод apply
  }
  val bob = new Person("Bob", "Developer")
  println(bob.worksAs("Developer")) // true
  // Мы вызываем метод через точечную нотация bob.worksAs
  // Его можно вызвать также в инфиксон нотации
  println(bob worksAs "Developer")
  println(bob.speaksEnglish)
  import scala.language.postfixOps
  println(bob speaksEnglish) // Постфиксная нотация, примяентся для методов без параметров

  // Операторы
  println(1 + 2) // Операторы являются методами, поэтому к ним можно обращаться в точечной нотации, но обычно используется инфиксная
  println(1.+(2)) // 1 + 2
  // Также операторы можно использовать в качестве имени метода
  val alice = new Person("Alice", "Data Engineer")
  println(alice & bob) // Так как метод & имеет только один параметр, то можно использовать инфиксную нотация
  println(alice.&(bob)) // Точечная нотация
  // Префиксная нотация
  val x = -1 // Префиксная нотация
  val x1 = 1.unary_- // Анологично записи выше, эквивалент unary можно использовать только с +-~!
  println(!bob) // Префиксная нотация
  println(bob.unary_!) // Точечная нотация
  println(bob unary_!) // Инфиксная нотация

  // Метод apply
  println(bob.apply("Samsung"))
  println(bob("Samsung")) // Аналогично записи выше, используется наиболее часто
  println(bob apply "Samsung") // Инфиксная нотация
}
