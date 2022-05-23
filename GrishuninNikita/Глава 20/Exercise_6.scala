/**
 * Измените парсер так, чтобы он генерировал правильное дерево синтаксического анализа.
 * Например, для выражения 3-4-5 он должен возвращать Operator("-", Operator("-", 3, 4), 5).
 */
object Exercise_6 extends App {
  import scala.util.parsing.combinator._
  class Expr
  case class Number(value: Int) extends Expr
  case class Operator(op: String, left: Expr, right: Expr) extends Expr

  class ExprParser extends RegexParsers {
    val number = "[0-9]+".r
    def expr: Parser[Expr] = term ~ rep( ("+" | "-") ~ term ) ^^ {
      case t ~ l => l.foldLeft(t)(
        (res, e) => e match {
          case "-" ~ n => Operator("-", res, n)
          case "+" ~ n => Operator("+", res, n)
        }
      )
    }
    def term: Parser[Expr] = factor ~ opt(("*" | "/" | "%") ~ term) ^^ {
      case f ~ None => f
      case f ~ Some("*" ~ e) => Operator("*", f, e)
      case f ~ Some("/" ~ e) => Operator("/", f, e)
      case f ~ Some("%" ~ e) => Operator("%", f, e)
    }
    def factor: Parser[Expr] = number ^^ {n => Number(n.toInt)} | "(" ~> expr <~ ")"
  }

  val parser = new ExprParser
  val result = parser.parseAll(parser.expr, "3-4-5")
  if(result.successful) println(result.get)
}
