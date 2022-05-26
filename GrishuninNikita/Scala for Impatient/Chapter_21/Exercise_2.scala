/**
 * Определите оператор +%, добавляющий указанный процент к значению.
 * Например, выражение 120 +% 10 должно вернуть 132.
 * Используйте неявный класс.
 */
object Exercise_2 extends App {
  class percent(val value: Int){
    def +%(percent: Double): Double = value + (value/percent)
  }
  implicit def int2Percent (value: Int): percent = new percent(value)
  val b = 120 +% 10
  println(b)
}
