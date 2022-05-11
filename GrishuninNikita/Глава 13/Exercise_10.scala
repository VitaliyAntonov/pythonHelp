/**
 *  Метод java.util.TimeZone.getAvailableIDs возвращает часовые пояса, такие как Africa/Cairo и Asia/Chungking.
 *  На каком континенте больше всего часовых поясов? Подсказка: groupBy
 */
import scala.jdk.CollectionConverters._
object Exercise_10 extends App {
  var b = java.util.TimeZone.getAvailableIDs()
  val pattern = """Africa|America|Australia|Asia|Pacific|Europe|Atlantic""".r
  val as = pattern.findAllIn(b.mkString).toArray
  val c = as.groupBy(identity).mapValues(_.size)
  println(c.mkString(", "))
}
