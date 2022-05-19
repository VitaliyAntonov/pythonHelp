/**
 * Почему RichInt реализует Comparable[Int], а не Comparable[RichInt]?
 * Тип Int в языке Scala не реализует интерфейса Comparable.
 * Однако его реализует тип RichInt, что приводит к неявному преобразованию значения типа Int
 * в значение типа RichInt.
 */

object Exercise_5 extends App {

}
