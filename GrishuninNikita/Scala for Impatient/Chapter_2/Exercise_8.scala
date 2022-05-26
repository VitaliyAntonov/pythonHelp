/**
 * Напишите функцию product(s : String), вычисляющую произведение,
 * как описано в предыдущих упражнениях.
 */
object Exercise_8 extends App {
  def product (s: String)  = {
    val arr = s.map(_.toInt).product
    println(arr)
    }
  val txt = scala.io.StdIn.readLine("Введите слово: ")
  product(txt)
}
