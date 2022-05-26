/**
 * В разделе 12.8 «Карринг» был представлен метод corresponds, использующий два массива строк.
 * Напишите вызов corresponds, который проверял бы соответствие длин строк
 * в одном массиве целочисленным значениям в другом.
 */

object Exercise_8 extends App{
  val a = Array("Hello", "World!")
  val b = Array(5, 25)
  val c = a.corresponds(b)(_.length == _)
  println(c)
}
