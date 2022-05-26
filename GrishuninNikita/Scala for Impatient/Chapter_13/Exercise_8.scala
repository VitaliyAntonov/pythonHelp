/**
 * Напишите функцию, превращающую массив значений Double в двумерный массив.
 * Число колонок должно передаваться в виде параметра.
 * Например, для Array(1, 2, 3, 4, 5, 6) и трех колонок
 * функция должна вернуть Array(Array(1, 2, 3), Array(4, 5, 6)).
 * Используйте метод grouped.
 */
object Exercise_8 extends App {
 def msv(a: Array[Double], c: Int) = {
  a.grouped(c).toArray
 }
 val b = Array(2.0, 3.0, 4.0, 5.0, 6.0)
 val c = msv(b, 3)
}
