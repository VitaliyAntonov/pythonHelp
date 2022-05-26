/**
 * Сигнум числа равен 1, если число положительное, -1 – если отрицательное,
 * и 0 – если оно равно нулю. Напишите функцию, вычисляющую это значение.
 */
import scala.io.StdIn
object Exercise_1 extends App {
 def sgn (x: Int) : Int = {
   if (x > 0) 1
   else if (x == 0) 0 else -1
  }
  print("Введите число: ")
  val x = StdIn.readInt()
  println("Сигнум числа равен: " + sgn(x))
}
