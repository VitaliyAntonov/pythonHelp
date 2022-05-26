package lectures.week2oop

object Inheritance { // Наследование
  class Person {
    private def greet: String = "Hello" // private делает метод доступным только классу в котором он описан
    protected def greet2: String = "Hello" // protected поля и метожы доступны только классу  и его подкласссам
  }

  class Student extends Person{
    println(student.greet2)

    override def greet2: String = super.greet2 // override позволяет переопределить метод наследуемого класса, super.greet2 - обращение к методы супер класса
  } // Наследование класса Person

  val student = new Student{ // Анонимный класс
    override def greet2: String = super.greet2
  }
  println(student)
  final class Std // final - запрещает наследование класса, в случае методов запрещает переопределение
  sealed class Std2 // Позволяет наследование только в текущем файле
  abstract class one // абстрактные классы повзоляют не определять методы и поля

}
