package exercises

object Ex11Implicits extends App {
  case class Person(age: Int) {
    def increaseAge: Unit = println(age + 1)
  }

  implicit def str2Person(param: String): Person = Person(param.toInt)
}
