/**
 * Напишите программу на Scala, которая читает текстовый файл и выводит все лексемы,
 * не являющиеся вещественными числами. Используйте регулярное выражение.
 */
object Exercise_7 extends App {
  import scala.io.Source
  val source = Source.fromFile("C:\\Users\\PROFESIONAL\\IdeaProjects\\Chapter_9\\src\\main\\scala\\txtFiles\\exercise_7.txt", "UTF-8")
  var pattern = """-?[0-9]+([.][0-9]+)""".r
  val arr = pattern.findAllIn(source.mkString).toArray
  println(arr.mkString(", "))
  source.close()
}
