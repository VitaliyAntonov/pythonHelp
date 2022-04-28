/**
 * Спроектируйте класс точки Point, значения координат x и y
 * которой передаются конструктору. Реализуйте подкласс точки
 * с подписью LabeledPoint, конструктор которого будет принимать строку с подписью
 * и значения координат x и y
 */
object Exercise_5 extends App{
  class Point(val x: Int, val y: Int){
    def apply(x:Int, y:Int) = new Point(x, y)
  }
  class LabeledPoint(label: String,x: Int, y: Int) extends Point(x, y){
  }
  val labelpoint = new LabeledPoint("LabeledPoint", 1232, 3232)
  }
