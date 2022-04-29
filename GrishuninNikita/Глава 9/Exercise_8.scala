/**
 * Напишите программу на Scala, которая выводит атрибуты src
 * всех тегов img в веб-странице. Используйте регулярные выражения и группы.
 */
object Exercise_8 extends App {
  import scala.io.Source
  val source = Source.fromURL("https://ru.wikipedia.org/wiki/Scala_(язык_программирования)", "UTF-8")
  val pattern = """<img.*\ssrc\s*=\s*"(.+)"""".r
  val arr = pattern.findAllIn(source.mkString).toArray
  println(arr.mkString(", "))
  source.close()
}
