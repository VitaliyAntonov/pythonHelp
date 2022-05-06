/**
 * Реализуйте метод corresponds без карринга.
 */

object Exercise_9 extends App{
  def corresponds(a: Array[String], b: Array[Int], f: (String, Int) => Boolean): Boolean =
    (a zip b).map(x => f(x._1, x._2)).foldLeft(true)(_ && _)
  val a = Array("Hello", "World!")
  val b = Array(5, 25)
  val c = corresponds(a, b, (x, y) => x.length == y)
  println(c)
}
