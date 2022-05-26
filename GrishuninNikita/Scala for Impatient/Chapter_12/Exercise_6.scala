/**
 * Измените предыдущую функцию так, чтобы она возвращала входное значение,
 * соответствующее наибольшему выходному значению.
 * Например, вызов largestAt(fun: (Int) => Int, inputs: Seq[Int]) должен вернуть 5.
 * Не используйте цикл илирекурсию.
 */

object Exercise_6 extends App{
  def largest(fun: (Int) => Int, inputs: Seq[Int]) = inputs.map(x => Tuple2(x, fun(x))).maxBy(_._2)
  val b = largest(x => 10 * x - x * x, 1 to 10)
  println(b)
}
