/**
 * Реализуйте класс Money с полями для выражения суммы в долларах и центах.
 * Реализуйте операторы +, -, а также операторы сравнения == и <.
 * Например, выражение Money(1, 75) + + Money(0,50) == Money(2, 25) должно возвращать true.
 * Следует ли также реализовать операторы * и /? Это не имеет смысла, зачем умножать и делать деньги.
 */
object Exercise_4 extends App {
  class Money(d: Int, c: Int) {
    var dollars = (d * 100 + c) / 100
    var cents = (d * 100 + c) % 100
    def toCents = cents + (dollars * 100)
    override def toString: String = dollars + "$" + "." + cents
    def +(other: Money): Money ={
      new Money(dollars + other.dollars, cents + other.cents)
    }
    def -(other: Money): Money ={
      new Money(dollars - other.dollars, cents - other.cents)
    }
    def ==(other: Money): Boolean = toCents == other.toCents
    def >(other: Money): Boolean = toCents > other.toCents
  }
  val b = new Money(25, 105)
  val c = new Money(25, 105)
  println((b + c).toString, b == c, c > b, b + c == c)
}
