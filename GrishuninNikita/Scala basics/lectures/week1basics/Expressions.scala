package lectures.week1basics

object Expressions extends App {
 //Блок кода - это все те строки кода, что мы пишем в фигурных скобках.
 val aCodeBlock = {
   val someVal = 1
   val y = 2

   if (someVal + y > 1) true else false
 }

  println(aCodeBlock) // выводит true

  val aCodeBlock2 = {
    val someVal = 1
    val y = 2

    if (someVal + y > 1) true else false

    "String to return"
  }


  println(aCodeBlock2) // выводит "String to return"
}
