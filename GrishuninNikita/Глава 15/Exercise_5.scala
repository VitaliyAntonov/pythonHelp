/**
 * Напишите метод, возвращающий строковое значение с содержимым текстового файла.
 * Вызовите его из Java.
 */
object Exercise_5 extends App{
  import scala.io._
  import java.io.File
  def str(file: File) = Source.fromFile(file).mkString
  val file = new File("C:\\Users\\PROFESIONAL\\IdeaProjects\\Chapter_15\\src\\main\\scala", "ex5.txt")
  println(str(file))
}

