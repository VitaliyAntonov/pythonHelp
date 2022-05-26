/**
 * Создайте коллекцию всех часовых поясов, возвращаемых методом
 * java.util.TimeZone.getAvailableIDs для Америки.
 * Отбросьте префикс "America/" и отсортируйте результат
 * filter(_.startsWith("America")) - Проверка на то имеет ли указанный массив нужное значение
 * map(_.stripPrefix(удаление префика)("America/")) - постройка массива, применяя заданную функцию ко всем её элементам
 */
object Exercise_10 extends App {
  val a = java.util.TimeZone.getAvailableIDs.filter(_.startsWith("America")).map(_.stripPrefix("America/")).sorted
  println(a.mkString(", "))
}
