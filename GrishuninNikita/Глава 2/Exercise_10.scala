/**
 *  Напишите функцию, вычисляющую x pow n, где n – целое число.
 */
import scala.math._
object Exercise_10 extends App {
  def func (x : Double, n : Int): Double = {
    if(n % 2 == 0 & n > 0) func(x, n/2) * func(x, n/2)
    else if (n > 0 && n % 2 != 0) x * func(x, n - 1)
    else if (n < 0) 1 / func(x, -n)
    else 1
  }
  println(func(0, 0))
}
