/**
 * Напишите функцию, принимающую элемент dl и превращающую его в Map[String, String].
 * Эта функция является полной противоположностью функции из предыдущего упражнения,
 * при условии что все дочерние элементы dt уникальны.
 */
import scala.io.Source
import scala.language.postfixOps
import scala.xml.parsing.XhtmlParser
import scala.xml.{Attribute, Elem, Node, Null}
import scala.xml.transform.{RewriteRule, RuleTransformer}
object Exercise_9 extends App{
  val rule = new RewriteRule {
    override def transform(n: Node) = n match {
      case img @ <img/> if img \ "@alt" isEmpty =>
        img.asInstanceOf[Elem] % Attribute(null, "alt", "TODO", Null)
      case _ => n
    }
  }
  val parser = new XhtmlParser(Source.fromFile("C:\\Users\\PROFESIONAL\\IdeaProjects\\Chapter_16\\src\\main\\scala\\htfile.html"))
  val doc = parser.initialize.document()
  val transformed = new RuleTransformer(rule).transform(doc)
  println(transformed)
}
