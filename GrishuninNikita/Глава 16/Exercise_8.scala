/**
 * Напишите функцию, принимающую элемент dl и превращающую его в Map[String, String].
 * Эта функция является полной противоположностью функции из предыдущего упражнения,
 * при условии что все дочерние элементы dt уникальны.
 */
object Exercise_8 extends App{
  import scala.xml.Elem
  def func(a: Map[String, String]) = {
   <dl>{for((k, v) <- a) yield <dt>{k}</dt><dd>{v}</dd>}</dl>
 }
  def func2(a: Elem): Map[String, String] = {
    ((a \\ "dt").map(_.text) zip (a \\ "dd").map(_.text)).toMap
  }
  val map = Map("A" -> "1", "B" -> "2")
  val map2 = func(map)
  val map3 = func2(map2)
  println(map3)
}
