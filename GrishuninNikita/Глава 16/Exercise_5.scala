/**
 * Выведите имена всех изображений в файле XHTML.
 * То есть выведите значения атрибутов src всех элементов img.
 */
import scala.language.postfixOps
import scala.xml.parsing.XhtmlParser
object Exercise_5 extends App{
  def loadFile(file: String) = {
    val parser = new XhtmlParser(scala.io.Source.fromFile(file))
    val doc = parser.initialize.document
    (doc \\ "img").foreach {
      n => {
        println(n \ "@name")
        println(n \ "@src")
      }
    }
  }
  loadFile("C:\\Users\\PROFESIONAL\\IdeaProjects\\Chapter_16\\src\\main\\scala\\htfile.html")
}
