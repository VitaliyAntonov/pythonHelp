/**
 * Определите класс Point с объектом-компаньоном,
 * чтобы можно было конструировать экземпляры Point, как Point(3, 4),
 * без ключевого слова new.
 */

object Exercise_4 extends App {
  class Point private (x: Int, y: Int){
  }
  object Point{
    def apply(x: Int, y: Int) = new Point(x, y)
  }
  val point = Point(3, 4)
}
