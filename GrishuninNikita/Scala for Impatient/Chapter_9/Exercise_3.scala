/**
 * Напишите фрагмент кода на Scala, который читает файл и выводит в консоль все слова,
 * содержащие 12 или более символов.
 * Дополнительные баллы начисляются тем, кто сможет сделать это в одной строке кода.
 */
object Exercise_3 extends App {
  import scala.io.Source
  val source = Source.fromFile("C:\\Users\\PROFESIONAL\\IdeaProjects\\Chapter_9\\src\\main\\scala\\txtFiles\\exercise_3.txt", "UTF-8")
  val lines = source.getLines.toArray.filter(_.length >=12)
  println(lines.mkString(", "))
  source.close()
}
