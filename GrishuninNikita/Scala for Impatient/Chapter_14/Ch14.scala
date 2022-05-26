
object Ch14 extends App {
  // 1 - стандартный case
  val aNumber = 44
  val ordinal = aNumber match{
    case 1 => "first"
    case 2 => "second"
    case 3 => "third"
    case _ => aNumber + "th"
  }
  // 2 - case class деконструкция
  case class Person(name: String, age: Int)
  val bob = Person("Bob", 34)
  val bobGreeting = bob match{
    case Person(n, a) => s"Hi, my name is $n and I am $a yeras old"
  }
  // 3 - case list экстрактор
  val list = List(1, 2, 3, 45)
  val mustHaveThree = list match{
    case List(_, _, 3, somethingElse) => s"List has 3rd element 3, so the 4th element is $somethingElse"
  }

}
