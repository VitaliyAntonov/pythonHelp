/**
 * Реализуйте операторы конструирования HTML-таблицы.
 */
import scala.collection.mutable.ArrayBuffer
object Exercise_5 extends App {
  class Table {
    // каждая строка - это массив ячеек
    val rows = new ArrayBuffer[ArrayBuffer[String]]()
    // Добавление столбца.
    // Если строк еще нет - первую строку нужно тоже создать и уже в нее положить ячейку
    // Иначе - укладываем ячейку в последнюю строку
    def |(str: String) = {
      if (rows.length == 0) rows += (new ArrayBuffer[String]() += str)
      else rows(rows.length - 1) += str
      this
    }
    // Добавляем новую строку в таблицу
    def ||(str: String) = {
      rows += (new ArrayBuffer[String]() += str)
      this
    }
    // Вывод таблицы
    override def toString: String =
      "<table>" +
        rows.map(
          "<tr>" + _.map("<td>" + _ + "</td>").mkString + "</tr>").mkString + "</table>"
  }
  object Table {
    def apply(): Table = new Table()
  }

  val t = Table() | "Java" | "Scala" || "Gosling" | "Odersky" || "JVM" | "JVM,.NET"
  println(t.toString)
}
