/**
 * Напишите функцию, удаляющую каждый второй элемент из ListBuffer.
 * Попробуйте два способа. Вызовите remove(i) для всех четных индексов i, начиная с конца списка.
 */
import scala.collection.mutable._

object Exercise_3 extends App {
  def rmv(s: ListBuffer[Int]) = {
    s.zipWithIndex
      .filter { case (_, i) => (i + 1) % 2 != 0 }
      .map { case (e, _) => e }
  }
  val b = ListBuffer(2, 3, 4, 5)
  val c = rmv(b)
  println(c)
}
