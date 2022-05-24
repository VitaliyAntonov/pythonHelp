/**
 * Определите оператор ! вычисления факториала, чтобы выражение 5.! возвращало 120.
 * Используйте неявный класс
 */
object Exercise_3 extends App {
  class factorial(val n: Int){
    def !(): Int = if(n == 0) 1 else n * (n-1).!
  }
  implicit def int2factorial (value: Int): factorial = new factorial(value)
  val b = 5.!
  println(b)
}
