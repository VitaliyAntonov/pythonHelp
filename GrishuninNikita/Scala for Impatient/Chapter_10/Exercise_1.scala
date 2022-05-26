/**
 *  Класс java.awt.Rectangle имеет очень удобные методы translate
 *  и grow, которые, к сожалению, отсутствуют в таких классах,
 *  как java.awt.geom.Ellipse2D. В Scala эту проблему легко исправить.
 *  Определите трейт RectangleLike с конкретными методами translate и grow
 */
object Exercise_1 extends App {
  trait RectangleLike extends java.awt.geom.RectangularShape{
    def translate(x: Int, y: Int): Unit ={
      setFrame(getX+x, getY+y, getWidth, getHeight)
    }
    def grow(h: Int, w: Int): Unit ={
      setFrame(getX, getY, getWidth + w, getHeight+h)
    }
  }
  val egg = new java.awt.geom.Ellipse2D.Double(5,10,20,30) with RectangleLike
  egg.translate(10,10)
  egg.grow(10,10)
  println(egg.getX,egg.getY, egg.getWidth, egg.getHeight)
}
