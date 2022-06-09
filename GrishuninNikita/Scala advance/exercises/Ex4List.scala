package exercises

object Ex4List extends App {
  def formatter(fNum: String)(num: Double): String = fNum.format(num)
  val simpleFormat = formatter("%.2f") _
  val numbers = List(3.1415)
  println(numbers.map(simpleFormat))
}
