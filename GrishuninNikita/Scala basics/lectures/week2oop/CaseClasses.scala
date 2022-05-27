package lectures.week2oop

object CaseClasses extends App {
  case class Person(name: String, occupation: String) // В кейс классе вы автоматически получаете доступ к параметрам, они по умолчанию val

  val bob = new Person("Bob", "Developer")
  val bobsDouble = new Person("Bob", "Developer")
  println(bob) // В таких класса информация автоматически выводится в понятном виде
  println(bob == bobsDouble) // Вернет true
  // В case классах доступен метод copy, он позволяет скопировать экземпляр класса, так и скопировать с измененными аругментами
  val bobsCopy = bob.copy(occupation = "Data Engineer") // К нему можно применить инфиксную нотацию
  val bobsCopyCopy = bob copy()
  // Любой case класс имеет объект компаньон, в нем всегда присутствует метод apply
  val alice = Person("Alice", "Engineer") // Метод apply позволяет объявлять экземпляр класса без слова new
}
