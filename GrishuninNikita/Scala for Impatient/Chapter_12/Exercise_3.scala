/**
 * Реализуйте функцию вычисления факториала с помощью методов
 * to и reduceLeft без применения цикла или рекурсии.
 */

object Exercise_3 extends App{
  def factorial(x: Int) = (1 to x).reduceLeft(_ * _)
  val b = factorial(3)
  println(b)
}
