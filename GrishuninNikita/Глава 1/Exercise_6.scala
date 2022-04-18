/**
 * Используя число типа BigInt, вычислите 2 в 1024-ой степени
 */
object Exercise_6 extends App {
  val x = BigInt(2).pow(1024) // pow(n) - возведение в n-ую степень
  println(x)
}
