/**
 * Напишите парсер, анализирующий дату и время в формате ISO 8601.
 * Парсер должен возвращать объект java.time.LocalDateTime.
 */
object Exercise_4 extends App {
  import scala.util.parsing.combinator._
  import java.time._
  class ExprParser extends RegexParsers {
    val number = "[0-9]+".r
    def date: Parser[LocalDate] = number ~ "-" ~ number ~  "-" ~ number ^^{
      case y ~ _ ~ m ~ _ ~ d => LocalDate.of(y.toInt, m.toInt, d.toInt)
    }
    def time: Parser[LocalTime] = number ~ ":" ~ number ~  ":" ~ number ^^{
      case h ~ _ ~ m ~ _ ~ s => LocalTime.of(h.toInt, m.toInt, s.toInt)
    }
    def datetime: Parser[LocalDateTime] = date ~ "T" ~ time ^^ {
      case d ~ _ ~ t => d.atTime(t)
    }
  }
  val parser = new ExprParser
  val result = parser.parseAll(parser.datetime, "2022-05-23T19:22:23")
  if(result.successful) println(result.get)
}
