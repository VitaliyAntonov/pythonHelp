/**
 * Решите предыдущее упражнение без применения цикла.
 * (Подсказка: загляните в описание класса StringOps в Scaladoc.)
 */
object Exercise_7 extends App {
  val txt = scala.io.StdIn.readLine("Введите слово: ")
  val arr = txt.map(_.toInt).product
  println(arr)

}
