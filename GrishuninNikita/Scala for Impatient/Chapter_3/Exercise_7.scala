/**
 * Напишите фрагмент программного кода, выводящий значения
 * всех элементов из массива, кроме повторяющихся. (Подсказка:загляните в Scaladoc.)
 */
object Exercise_7 extends App {
  val arr = Array(2, 1, 5, 3, 3, 4)
  println(arr.distinct.mkString(", ")) //.distinct - выбирает все элементы массива игнорируя дубликаты
}