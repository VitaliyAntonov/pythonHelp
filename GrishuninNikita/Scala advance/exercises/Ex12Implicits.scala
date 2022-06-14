package exercises

object Ex12Implicits extends App {
  case class Price(price: Int)
  object Price{
    implicit class PriceOps(p: Price) {
      def - (n: Int): Price = Price(p.price - n)
    }
  }
  println(Price(500) - 50)
}
