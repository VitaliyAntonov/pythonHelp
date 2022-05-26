package lectures.week2oop

object ClassesOOP extends App {
  class Student(val id: Int = 0, val name: String = "NoName"){ // Также можно использовать параметры по умолчанию
    val uni = "University"
    def getId(id: Int, name: String) = s"$name has ID $id and $name has ID $id" // Выведутся только параметры метода класса
    def getId2(id: Int, name: String) = s"${this.name} has ID ${this.id} and $name has ID $id" // this позволяет обращаться к параметрам класса
    def getId = s"$name has ID $id and $name has ID $id" // Перегрузка метода позволяет иметь функции с одинаковым название, главное чтобы набор передаваемых параметров отличался
  } // Создание класса
  val student = new Student(34, "Jonh") // Создание экземпляра класса
  println(student.getId(1, "Sam"))
  println(student.getId2(1, "Bob"))
}
