/**
 * Напишите парсер, анализирующий список целых чисел (такой как (1, 23, -79)) и возвращающий List[Int].
 */
object Exercise_3 extends App {
  import scala.util.parsing.combinator._
  class ExprParser extends RegexParsers {
    val number = "[0-9]+".r
    def list: Parser[List[Int]] = "(" ~> repsep(number, ", ") <~ ")" ^^ { // комбинатор repsep обрабатывает общий случай повторени элементов с разделителем
      case f => f.map(_.toInt)
    }
  }
  val parser = new ExprParser
  val result = parser.parseAll(parser.list, "(1, 2, 3, 4, 5)")
  if(result.successful) println(result.get)
}
