package exercises

object Ex17Week2 extends App {
  import scala.io.StdIn.readLine
  val input: String = readLine()
  def countNumbers(s: String): Unit = {
    val pattern = """[0-9]""".r
    val b = pattern.findAllIn(s).mkString
    println(b.toSet)
  }
  countNumbers(input)
}
