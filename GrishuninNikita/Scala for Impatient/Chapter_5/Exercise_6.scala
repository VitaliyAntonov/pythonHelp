/**
 *  В классе Person из раздела 5.1 «Простые классы и методы без
 *  параметров» реализуйте главный конструктор, преобразующий отрицательное
 *  значение возраста в 0.
*/
object Exercise_6 extends App {
  class Person {
    private var privateAge = 0
    def age = privateAge
    def newage (newValue: Int) {
      if (newValue < 0) privateAge = 0;//Если возраст отрицательный то он преобразуется в 0
    }
  }
  val prsn = new Person
  prsn.newage(-2)
  println(prsn.age)
}
