package lectures.week1basics

object StringOperations extends App {
  val aString = "Scala course"
  println(aString.length) // выводит 13
  println(aString.charAt(1)) // выводит e
  println(aString.substring(0, 2)) // выводит He
  println(aString.split(" ").toList) // выводит List(Hello,, world!)
  println(aString.startsWith("He")) // выводит true
  println(aString.replace("!", ".")) // выводит Hello, world.
  println(aString.toLowerCase) // выводит hello, world!
  println(aString.toUpperCase) // выводит HELLO, WORLD!
  println("abcd".reverse) // выводит dcba
  println("abcd".take(2)) // выводит ab
  println('1' +: "42" :+ '3') // выводит 1423
  println('a' +: "bc" :+ 'd') // abcd
  println("a" ++ "bc" :++ "d") // abcd
  println(1 +: List(2, 3)) // List(1, 2, 3)
  println(List(1, 2) ++ List(3, 4)) // List(1, 2, 3, 4)
  println(List(1, 2) +: List(3, 4)) //List(List(1, 2), 3, 4)
  // Интерполятор s-интерполятор - используется для подставления значения переменной типа String в строку.
  val name = "John"
  println(s"Hello, $name") // выводит Hello, John
  //Обратите внимание на использование $ в коде. Это гарантирует, что name будет интерпретировано как переменная, значение которой требуется подставить в строку.
  //Если необходимо вставить выражение, то это выражение указываем в фигурных скобках
  val surname = "Smith"
  println(s"Hello, ${name + surname}") // выводит Hello, JohnSmith
}
