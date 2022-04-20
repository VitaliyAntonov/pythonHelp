/**
 * Напишите фрагмент кода, который записывает в массив a целые
 * числа в диапазоне от 0 (включительно) до n (исключая его).
 */

import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn
import scala.util._
object Exercise_1 extends App {
  print("Введите число n: ")
  val n = StdIn.readInt()
  val a = new Array[Int](n)
  for(i <- 0 until n){
    a(i) = i
  }
  print(a.mkString(", "))
}
