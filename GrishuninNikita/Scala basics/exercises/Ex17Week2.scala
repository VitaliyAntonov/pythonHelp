package exercises

object Ex17Week2 extends App {
  import scala.io.StdIn.readLine
  val input: String = readLine()
  def countNumbers(s: String): Map[Char, Int] = s.foldLeft(Map[Char, Int]().withDefaultValue(0)){
    case (acc, letter)  =>
      if (letter != '-') acc + (letter -> (1 + acc(letter)))
      else acc
  }
  }

