/**
 * Обобщите метод average из раздела 21.8 «Классы типов» до Seq[T].
 */
object Exercise_10 extends App {
  trait NumberLike[T] {
    def plus(x: T, y: T): T
    def divideBy(x: T, n: Int): T
  }
  object NumberLike {
    implicit object NumberLikeDouble extends NumberLike[Double] {
      def plus(x: Double, y: Double) = x + y
      def divideBy(x: Double, n: Int) = x / n
    }
    implicit object NumberLikeBigDecimal extends NumberLike[BigDecimal] {
      def plus(x: BigDecimal, y: BigDecimal) = x + y
      def divideBy(x: BigDecimal, n: Int) = x / n
    }
  }
  def average[T: NumberLike](elems: T*) ={
    val nl = implicitly[NumberLike[T]]
    val tl = elems.reduce(nl.plus)
    nl.divideBy(tl, elems.length)
  }
}
