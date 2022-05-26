/**
 * Реализуйте предыдущее упражнение с использованием неизменяемого ассоциативного массива символов в списки.
 */
import scala.collection.mutable._

object Exercise_2 extends App {
  def indexes(s: String): HashMap[Char, Set[Int]] =
    s.zipWithIndex.foldLeft(HashMap[Char, Set[Int]]())((res, el) =>
      res + (el._1 -> (res.getOrElse(el._1, Set[Int]()) + el._2)))
  val str = indexes("Mississipi")
  println(str)
}
