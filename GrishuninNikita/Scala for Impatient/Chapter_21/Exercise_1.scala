/**
 * Как действует оператор ->?
 * То есть как заставить выражения "Hello" -> 42 и 42 -> "Hello" образовывать пары ("Hello", 42) и (42, "Hello")?
 * Подсказка: Predef.any2ArrowAssoc.
 * val ->: Tuple2.type
 * -> Позволяет образовывать пары
 */
object Exercise_1 extends App {
  class ArrowAssoc[A](self: A){
    def ->[B](y: B): (A, B) = (self, y)
  }
  val tup = "foobar" -> 3
  println(tup)
}
