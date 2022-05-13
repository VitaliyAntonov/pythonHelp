import scala.math.sqrt

/**
 * Напишите функцию, получающую две функции типа Double => Option[Double] и конструирующую на их основе
 * третью функцию того же типа. Новая функция должна возвращать None, если любая из двух исходных функций
 * вернет это значение.
 */
object Exercise_10 extends App{
 def f(x: Double) = if (x != 1) Some(1 / (x - 1)) else None
 def g(x: Double) = if (x >= 0) Some(sqrt(x)) else None
 def c(f1: Double => Option[Double], f2: Double => Option[Double]): Double => Option[Double] =
  (x:Double) => f2(x) match {
   case Some(f2x) => f1(f2x)
   case None => None
  }
 val h = c(f, g)
}
