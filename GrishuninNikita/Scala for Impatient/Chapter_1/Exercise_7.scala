/**
 *  Что нужно импортировать, чтобы найти случайное простое число вызовом метода
 *  probablePrime(100, Random) без использования каких-либо префиксов
 *  перед именами probablePrime и Random?
 *  Нужно импортировать
 *  import scala.math.BigInt.probablePrime
 *  import scala.util._
 */
import scala.math.BigInt.probablePrime
import scala.util._
object Exercise_7 extends App {
  val x = probablePrime(1, Random)
  println(x)
}
