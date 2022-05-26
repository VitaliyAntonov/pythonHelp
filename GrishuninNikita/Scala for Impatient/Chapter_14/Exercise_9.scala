/**
 * Напишите функцию, вычисляющую сумму всех непустых значений в List[Option[Int]].
 * Не используйте выражения match.
 */
object Exercise_9 extends App{
 def sum (l: List[Option[Int]]) = l.flatMap(x => x).sum
  val a = List(Some(1), Some(2), None)
  println(sum(a))
}
