/**
 * Напишите функцию adjustToPair, принимающую функцию типа (Int, Int) => Int
 * и возвращающую эквивалентную функцию, оперирующую парой.
 * Например, вызов adjustToPair(_ * _)((6, 7)) должен вернуть 42.
 */

object Exercise_7 extends App{
  def adjustToPair(fun: (Int, Int) => Int) = (t:(Int, Int)) => fun(t._1,t._2)
  var b = adjustToPair(_ * _)((6, 7))
  var c = ((1 to 10) zip (11 to 20)).map(adjustToPair(_ + _))
  println(b, c)
}
