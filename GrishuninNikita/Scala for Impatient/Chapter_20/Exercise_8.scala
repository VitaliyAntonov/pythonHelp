/**
 * Добавьте поддержку переменных и операции присваивания в программу калькулятора.
 * Переменные должны создаваться при первом их использовании.
 * Неинициализированные переменные должны иметь нулевое значение.
 * Для вывода значения оно должно присваиваться специальной переменной out.
 */
object Exercise_8 extends App {
  import scala.util.parsing.combinator._
  class ExprParser extends RegexParsers {
    val number = "[0-9]+".r
    val name = "[a-z]+".r
    val map = scala.collection.mutable.Map[String, Int]()
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
    def factor: Parser[Int] = number ^^ {_.toInt} | name ^^ {map.getOrElse(_, 0)} | "(" ~> expr <~ ")"

    def assign = (name <~ "=") ~ expr ^^ {
      case "out" ~ e => println(e)
      case n ~ e => map.update(n, e)
    }
    def language = rep(assign <~ ";")
  }
  val parser = new ExprParser
  val result = parser.parseAll(parser.language, "a=5; b=12; c=a+b; out=c")
}
