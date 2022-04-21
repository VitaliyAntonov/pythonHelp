/**
 * Определите связанную хеш-таблицу, отображающую "Monday"
 * в java.util.Calendar.MONDAY, и так далее для других дней недели.
 * Продемонстрируйте обход элементов в порядке их добавления.
 */

import java.util.Calendar._
object Exercise_6 extends App{
  var days = scala.collection.mutable.LinkedHashMap(
    "Monday" -> java.util.Calendar.MONDAY,
    "Tuesday" -> java.util.Calendar.TUESDAY,
    "Wednesday" -> java.util.Calendar.WEDNESDAY,
    "Thursday" -> java.util.Calendar.THURSDAY,
    "Friday" -> java.util.Calendar.FRIDAY,
    "Saturday" -> java.util.Calendar.SATURDAY,
    "Sunday" -> java.util.Calendar.SUNDAY)
  println(days.mkString(", "))
}
