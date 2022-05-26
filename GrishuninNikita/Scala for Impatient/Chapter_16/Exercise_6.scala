/**
 * Прочитайте файл XHTML и выведите таблицу всех гиперссылок в файле вместе с их адресами URL.
 * То есть выведите содержимое дочернего текстового узла и значение атрибута href каждого элемента a.
 */
import scala.language.postfixOps
import scala.xml.parsing.XhtmlParser

object Exercise_6 extends App{
  def loadFile(file: String) = {
    val parser = new XhtmlParser(scala.io.Source.fromFile(file))
    val doc = parser.initialize.document
    for (a <- doc \\ "a"; href <- a.attribute("href")) {
      println(s"${a.text}:\t$href")
    }
  }
  loadFile("C:\\Users\\PROFESIONAL\\IdeaProjects\\Chapter_16\\src\\main\\scala\\htfile.html")
}
