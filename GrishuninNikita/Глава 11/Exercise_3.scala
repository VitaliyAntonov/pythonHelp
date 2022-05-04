/**
 * Реализуйте класс Fraction с операциями + - * /. Реализуйте нормализацию рациональных чисел,
 * например чтобы число 15/–6 превращалось в –5/3, а также деление на наибольший общий делитель.
 */
object Exercise_3 extends App {
  class Fraction(n: Int, d: Int) {
    private val num: Int = if (d == 0) 1 else n * sign(d) / gcd(n, d);
    private val den: Int = if (d == 0) 0 else d * sign(d) / gcd(n, d);
    override def toString = num + "/" + den

    def sign(a: Int) = if (a > 0) 1 else if (a < 0) -1 else 0
    def gcd(a: Int, b: Int): Int = if (b == 0) abs(a) else gcd(b, a % b)
    def abs(a: Int): Int = if (a > 0) a else -a
    def lcd(a: Int, b: Int): Int = abs(a * b) / gcd(a, b)

    def *(other: Fraction) = {
      new Fraction((num * other.num), den * other.den)
    }
    def /(other: Fraction) = {
      new Fraction((num * other.den), (den * other.num))
    }
    def +(other: Fraction) = {
      val ldn = lcd(den, other.den)
      new Fraction(num * (ldn / den) + other.num * (ldn / other.den), ldn)
    }
    def -(other: Fraction) = {
      val ldn = lcd(den, other.den)
      new Fraction(num * (ldn / den) - other.num * (ldn / other.den), ldn)
    }

  }
  val a = new Fraction(6, -3)
  val b = new Fraction(4, 3)
  println(a.toString, b.toString, a * b, a / b, a + b, a - b)

}
