/**
 * Прочитайте файл XHTML и выведите все элементы img, не имеющие атрибута alt
 */
import scala.language.postfixOps
import scala.xml.parsing.XhtmlParser
object Exercise_4 extends App{
  def loadFile(file: String) = {
    val parser = new XhtmlParser(scala.io.Source.fromFile(file))
    val doc = parser.initialize.document
    doc \\"@img" filter({_\"@alt" isEmpty})
  }
  val b = loadFile("C:\\Users\\PROFESIONAL\\IdeaProjects\\Chapter_16\\src\\main\\scala\\htfile.html")
  println(b)
}
