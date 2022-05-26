/**
 * Напишите процедуру countdown(n: Int), которая выводит числа от n до 0.
 */
import scala.io.StdIn
object Exercise_5 extends App {
  def countdown (n:Int) : Unit = {
    for(i <- n to 0 by -1)
      println(i)
  }
  print("Введите число: ")
  var n = StdIn.readInt()
  countdown(n)
}
