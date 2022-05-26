/**
 * Определите класс-значение Point, упаковывающий целочисленные координаты x и y в поле типа Long
 * (которое вы должны сделать приватным)
 */
import java.awt.Dimension
object Exercise_11 extends App{
  class Point(x: Long, y: Long){
    private def apply(x: Long, y: Long) = new Point(x,y)
  }
}