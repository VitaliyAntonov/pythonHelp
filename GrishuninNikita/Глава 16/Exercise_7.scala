/**
 * Напишите функцию, принимающую параметр типа Map[String, String]
 * и возвращающую элемент dl с элементом dt – для каждого ключа и dd – для каждого значения.
 */
object Exercise_7 extends App{
 def func(a: Map[String, String]) = {
   <dl>{for((k, v) <- a) yield <dt>{k}</dt><dd>{v}</dd>}</dl>
 }
  val map = Map("A" -> "1", "B" -> "2")
  println(func(map))
}
