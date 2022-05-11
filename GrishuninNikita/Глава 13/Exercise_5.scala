/**
 * Реализуйте функцию, действующую подобно mkString, используя reduceLeft.
 */
object Exercise_5 extends App {
 def mkString(a: Array[Any], sm: String) = a.reduceLeft(_.toString + sm + _.toString)
 val b: Array[Any] = Array(1, 2, 3)
 println(mkString(b, ", "))
}
