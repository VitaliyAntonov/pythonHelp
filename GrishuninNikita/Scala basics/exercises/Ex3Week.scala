package exercises

object Ex3Week extends App {
  val input = "I like        Scala"
  println(input.replaceAll(raw"\s+", " ").split(" ").reverse.mkString(" "))
}
