/**
 * Определите класс квадрата Square, наследующий класс java.awt.Rectangle
 * и имеющий три конструктора: один, создающий квадрат по указанным координатам угла и ширине,
 * другой, создающий квадрат с углом в точке (0, 0) с указанной шириной,
 * и третий, создающий квадрат с углом в точке (0, 0) с шириной 0.
 */
import java.awt.Point
import java.awt.Dimension
object Exercise_7 extends App{
  class Square(p: Point, size:Int) extends java.awt.Rectangle(p, new Dimension(size,size)){
    def this(size: Int) {
      this(new Point(0,0),size)
    }
    def this() {
      this(0)
    }
  }
  var sq1 = new Square(new Point(1,2),3)
  var sq2 = new Square(3)
  var sq3 = new Square()
  }
