package lectures.week1basics

object Functions extends App{
  def aPerson(name: String, surname: String): String = {
    s"$name $surname"
  }
  println(aPerson("John", "Smith"))
  // Кстати, вполне возможно прописать print в теле самой функции, просто для этого необходимо изменить тип возвращаемого значения на Unit:
  def aPerson2(name: String, surname: String): Unit = println(s"$name $surname")
  aPerson2("John" , "Smith")

  // Вызов по имени(call-by-name) vs Вызов по значению(call-by-value)
  def callByValue(x: Long): Unit = {
    println(s"call by value: x1 = $x")
    println(s"call by value: x2 = $x")
  }

  def callByName(x: => Long): Unit = {
    println(s"call by name: x1 = $x")
    println(s"call by name: x2 = $x")
  }

  callByValue(System.nanoTime())
  callByName(System.nanoTime())
  // Вызов по значению подразумевает вычисление значения переданного выражения перед вызовом функции.
  //          Преимущество: значение вычисляется только один раз.
  // Вызов по имени подразумевает вычисление значения выражения в момент его вызова в функции
  //          Преимущество: значение не вычисляется, если не используется в теле функции.
}
