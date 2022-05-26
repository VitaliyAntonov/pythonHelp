/**
 * Определите абстрактный класс геометрической фигуры Shape
 * с абстрактным методом centerPoint и подклассы прямоугольника и окружности,
 * Rectangle и Circle. Реализуйте соответствующие конструкторы в подклассах и
 * переопределите метод centerPoint в каждом подклассе.
 */
import Exercise_5.Point
object Exercise_6 extends App{
  abstract class Shape{
    def centerPoint
  }
  class Rectangle (pnt: Point, width: Int, height: Int) extends Shape{
    override def centerPoint: Unit = {
      def apply(pnt: Point, width: Int, height: Int) = new Point((pnt.x+width)/2,(pnt.y+height)/2)
    }
  }
  class Circle(pnt: Point, radius: Int) extends Shape{
    override def centerPoint: Unit = {
      def apply(pnt: Point, diameter: Int) = new Point((pnt.x+radius), (pnt.y+radius))
    }
  }
  }
