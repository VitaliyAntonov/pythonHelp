/**
 * В разделе 20.6 «Уход от левой рекурсии» мы сначала выполняли парсинг expr в список ~ с операциями и
 * значениями: def expr: Parser[Int] = term ~ rep(("+" | "-") ~ term) ^^ {...}
 * Реализуйте это вычисление как свертку.
 * Не понял задание, взял код из 20.6, добавил что было в предущих заданиях
 */
object Exercise_7 extends App {
  import scala.util.parsing.combinator._
  class ExprParser extends RegexParsers {
    val number = "[0-9]+".r
    def expr: Parser[Int] = term ~ rep(("+" | "-") ~ term ^^ {
        case "+" ~ t => t
        case "-" ~ t => -t
      }) ^^ { case t ~ r => t + r.sum }

    def term: Parser[Int] = factor ~ opt(("*" | "/" | "%" ) ~ term) ^^ {
      case f ~ None => f
      case f ~ Some("*" ~ e) => f * e
      case f ~ Some("/" ~ e) => f / e
      case f ~ Some("%" ~ e) => f % e
    }
    def factor: Parser[Int] = number ^^ {_.toInt} | "(" ~> expr <~ ")"
  }
  val parser = new ExprParser
  val result = parser.parseAll(parser.expr, "3-4-5")
  if(result.successful) println(result.get)
}
