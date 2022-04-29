/**
 * Напишите регулярное выражение для поиска строк в кавычках "как эта, возможно с \" или \\".
 */
object Exercise_6 extends App {
  import scala.io.Source
  val source = Source.fromFile("C:\\Users\\PROFESIONAL\\IdeaProjects\\Chapter_9\\src\\main\\scala\\txtFiles\\exercise_6.txt", "UTF-8")
  var pattern = """([^\\"]|\\\\|\\")*""".r
  val arr = pattern.findAllIn(source.mkString).toArray
  println(arr.mkString(", "))
  source.close()
}
