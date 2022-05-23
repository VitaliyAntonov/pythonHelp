/**
 * Добавьте в парсер арифметических выражений оператор ^.
 * Как и в математике, оператор ^ должен иметь более высокий приоритет, чем оператор умножения,
 * и должен быть правоассоциативным.
 * То есть выражение 4^2^3 должно интерпретироваться как 4^(2^3) и давать в результате значение 65536.
 */
object Exercise_2 extends App {
  import scala.util.parsing.combinator._
  class ExprParser extends RegexParsers {
    val number = "[0-9]+".r
    def expr: Parser[Double] = term ~ opt(("+" | "-") ~ expr) ^^ {
      case t ~ None => t
      case t ~ Some("+" ~ e) => t + e
      case t ~ Some("-" ~ e) => t - e
    }
    def term: Parser[Double] = factor ~ opt(("*" | "/" | "%" | "^") ~ term) ^^ {
      case f ~ None => f
      case f ~ Some("*" ~ e) => f * e
      case f ~ Some("/" ~ e) => f / e
      case f ~ Some("%" ~ e) => f % e
      case f ~ Some("^" ~ e) => math.pow(f, e)
    }
    def factor: Parser[Double] = number ^^ {_.toDouble} | "(" ~> expr <~ ")"
  }
  val parser = new ExprParser
  val result = parser.parseAll(parser.expr, "4^2^3")
  if(result.successful) println(result.get)
}
