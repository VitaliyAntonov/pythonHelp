/**
 * Реализуйте все необходимое для вычисления выражения smaller(Fraction(1, 7), Fraction(2, 9))
 * с классом Fraction из главы 11. Добавьте неявный класс RichFraction, наследующий Ordered[Fraction].
 */
object Exercise_5 extends App {
  case class Fraction(val n: Int, val d: Int)
    def smaller[T](a: T, b: T)(implicit order: T => Ordered[T]): T = if (a < b) a else b
  class RichFraction(val f: Fraction) extends Ordered[Fraction] {
    def compare(that: Fraction):Int = (f.n * that.d) - (that.n * f.d)
  }
  implicit def Fraction2RichFraction(f: Fraction): RichFraction = new RichFraction(f)
  val b = smaller(Fraction(1, 7), Fraction(2, 9))
  println(b)
}
