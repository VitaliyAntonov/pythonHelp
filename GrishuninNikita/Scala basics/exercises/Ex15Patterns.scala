package exercises

object Ex15Patterns {
  import scala.io.StdIn.readLine
  def main(args : Array[String]) = {
    def initials(str: String): String={
      str match{
        case str: String => {
          val pattern = """[A-Z]""".r
          val onlyStr = pattern.findAllIn(str).mkString
          if(onlyStr.flatMap(c => (c + ". ")) == "") "Oops, something is Wrong"
          else onlyStr.flatMap(c => (c + ". "))
        }
        case _ => "Oops, something is wrong"
      }
    }
    val input = readLine()
    println(initials(input))
  }
}
