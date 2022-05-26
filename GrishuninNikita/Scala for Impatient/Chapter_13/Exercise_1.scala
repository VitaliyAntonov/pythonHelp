/**
 * Напишите функцию, возвращающую для указанной строки отображение индексов всех символов.
 * Например, вызов indexes("Mississippi") должен вернуть ассоциативный массив,
 * связывающий 'M' со множеством {0}, 'i' – со множеством {1, 4, 7, 10} и т. д
 */
import scala.collection.mutable._
object Exercise_1 extends App {
  def indexes(s: String): LinkedHashMap[Char, SortedSet[Int]] =
    s.zipWithIndex.foldLeft(LinkedHashMap[Char, SortedSet[Int]]())((res, el) =>
      res += (el._1 -> (res.getOrElse(el._1, SortedSet[Int]()) + el._2)))
  val str = indexes("Mississipi")
  println(str)
}
