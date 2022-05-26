/**
 * Добавьте в парсер арифметических выражений операции / и %.
 */
object Exercise_1 extends App {
  import scala.util.parsing.combinator._
  class ExprParser extends RegexParsers {
    val number = "[0-9]+".r
    def expr: Parser[Double] = term ~ opt(("+" | "-") ~ expr) ^^ {
      case t ~ None => t
      case t ~ Some("+" ~ e) => t + e
      case t ~ Some("-" ~ e) => t - e
    }
    def term: Parser[Double] = factor ~ opt(("*" | "/" | "%" ) ~ term) ^^ {
      case f ~ None => f
      case f ~ Some("*" ~ e) => f * e
      case f ~ Some("/" ~ e) => f / e
      case f ~ Some("%" ~ e) => f % e
    }
    def factor: Parser[Double] = number ^^ {_.toDouble} | "(" ~> expr <~ ")"
  }
  val parser = new ExprParser
  val result = parser.parseAll(parser.expr, "(12/4)*5")
  if(result.successful) println(result.get)
}
