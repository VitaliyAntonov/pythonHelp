/**
 * Используя сопоставление с образцом, напишите функцию
 * swap, которая принимает пару целых чисел и возвращает ту же пару, поменяв компоненты местами.
 */

object Exercise_2 extends App{
  def swap(x: Int, y: Int) = {
    (x, y) match{
      case (x, y) => (y, x)
    }
  }
  println(swap(1,2))
}
