/**
 * Напишите функцию leafSum для вычисления суммы всех значений листьев,
 * используя сопоставление с образцом для отделения чисел от списков.
 */
object Exercise_5 extends App{
  def leafSum(l: List[Any]): Int = l.map({
    case l: List[Any] => leafSum(l)
    case i: Int => i
    case _ => 0
  }).sum
  val l = List(List(3, 8), 2, List(5))
  val b = leafSum(l)
  println(b)
}
