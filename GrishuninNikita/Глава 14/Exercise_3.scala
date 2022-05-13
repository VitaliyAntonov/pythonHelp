/**
 * Используя сопоставление с образцом, напишите функцию swap,
 * которая меняет местами первые два элемента массива, если он имеет длину не меньше двух.
 */
object Exercise_3 extends App{
  def swap(arr: Array[Int]): Array[Int] = {
    arr match{
      case Array(x, y) => Array(y, x)
      case Array(x, y, rest @ _*)  => Array((y +: x +: rest):_*)
      case Array(_) => arr
    }
  }
  val a = swap(Array(1, 2))
  val b = swap(Array(1, 2, 3, 4))
  val c = swap(Array(1))
  println(a.mkString(","))
  println(b.mkString(","))
  println(c.mkString(","))
}
