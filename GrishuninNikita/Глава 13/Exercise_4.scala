/**
 * Напишите функцию, принимающую коллекцию строк и ассоциативный массив, отображающий строки в целые числа.
 * Она должна возвращать коллекцию целых чисел, значения которых соответствуют строкам в ассоциативном массиве,
 * повторяющимся в исходной коллекции.
 * Например, для Array("Tom", "Fred", "Harry") и Map("Tom" -> 3, "Dick" -> 4, "Harry" -> 5)
 * функция должна вернуть Array(3, 5).
 * Подсказка: используйте flatMap для объединения значений типа Option, возвращаемых методом get.
 */
import scala.collection.mutable._

object Exercise_4 extends App {
 def clc(a : Array[String], b: Map[String, Int]): Array[Int] = a.flatMap(b.get(_)) // get - возвращается значения, связанные с ключом
  val arr = Array("Tom", "Fred", "Harry")
  val mp = Map("Tom" -> 3, "Dick" -> 4, "Harry" -> 5)
  val r = clc(arr, mp)
  println(r.mkString(", "))
}
