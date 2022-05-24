/**
 * Реализуйте лексикографическое сравнение объектов класса java.awt.Point.
 */
object Exercise_6 extends App {
  import java.awt.Point
  implicit class RichFraction(val p: Point) extends Ordered[Point] {
    def compare(that: Point):Int = {
      if (p.x == that.x)
        p.y.compare(that.y)
      else
        p.x.compare(that.x)
    }
  }
  val b = new Point(3, 4) < new Point(4, 5)
  println(b)
}
