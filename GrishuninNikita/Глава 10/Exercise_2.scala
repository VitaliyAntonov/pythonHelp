/**
 *  Определите класс OrderedPoint, подмешав scala.math.Ordered
 *  [Point] в java.awt.Point. Используйте лексикографическое упорядочение,
 *  то есть (x, y) < (x′, y′), если x < x′ или x = x′ и y < y′
 */
import java.awt.Point
object Exercise_2 extends App {
  class OrderedPoint (x: Int, y: Int) extends Point(x, y) with scala.math.Ordered[java.awt.Point] {
  override def compare(other: java.awt.Point) ={
    if(getX < other.getX || (getX == other.getX && getY < other.getY)) -1
    else if(getX == other.getX && getX == other.getX) 0
    else 1
  }
  }
  val point1 = new OrderedPoint(1,1)
  val point2 = new OrderedPoint(1,1)
  println(point1.compare(point2))
}
