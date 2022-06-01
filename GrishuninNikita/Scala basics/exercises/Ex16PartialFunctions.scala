package exercises

object Ex16PartialFunctions extends App {
  val aPartialFunction: PartialFunction[String, String] = {
    case "hello" => "Hi, I'm Bot"
    case "bye" => "Bye-bye"
    case "what's up" => "sup-sup"
  }
  val chatbot = aPartialFunction.lift
  scala.io.Source.stdin.getLines().map(chatbot).foreach(println)
}
