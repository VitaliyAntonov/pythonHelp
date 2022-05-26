/**
 * Сделайте тип String членом класса типов NumberLike из раздела 21.8 «Классы типов».
 * Метод divBy должен сохранять каждую n-ю букву, то есть вызов average("Hello", "World") должен
 * вернуть "Hlool".
 */
object Exercise_11 extends App {
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
    implicit object NumberLikeString extends NumberLike[String] {
      def plus(x: String, y: String) = x + y
      def divideBy(x: String, n: Int) = {
        (for ((c, i) <- x.zipWithIndex if i % n == 0) yield c).mkString
      }
    }
  }
  def average[T: NumberLike](elems: T*) ={
    val nl = implicitly[NumberLike[T]]
    val tl = elems.reduce(nl.plus)
    nl.divideBy(tl, elems.length)
  }
}
