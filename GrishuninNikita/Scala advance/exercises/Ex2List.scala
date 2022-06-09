package exercises

object Ex2List extends App {
  def countChars(s: String): Map[Char, Int] = s.toLowerCase.foldLeft(Map[Char, Int]().withDefaultValue(0)) {
    case (acc, letter) =>
      if (letter != '-') acc + (letter -> (1 + acc(letter)))
      else acc
  }
  val inputString = "Sst"
  println(countChars(inputString).toList.sortBy(_._2))
}
