/**
 * Продолжите предыдущее упражнение и реализуйте сравнение
 * двух точек на координатной плоскости по их расстояниям от центра координат.
 */
object Exercise_7 extends App {
  import java.awt.Point
  implicit class RichFraction(val p: Point) extends Ordered[Point] {
    def compare(that: Point):Int = {
      if (math.sqrt(math.pow(p.x, 2) + math.pow(p.y, 2)) == math.sqrt(math.pow(that.x, 2) + math.pow(that.y, 2)))
        p.y.compare(that.y)
      else
        p.x.compare(that.x)
    }
  }
  val b = new Point(3, 4) < new Point(4, 5)
  println(b)
}
