/**
 * Определите операцию unapply для класса RichFile, извлекающую путь к файлу,
 * имя и расширение. Например, файл /home/cay/readme.txt имеет путь /home/cay, имя readme и расширение txt.
 */
object Exercise_9 extends App {
  object RichFile{
    def unapply(s: String): Option[(String,String,String)] = {
      // (.*[\/\\])*(.+)[.]([^.]+)
      // (        - группируем
      // .*       - любое количество любых знаков
      // [\/ \\]  - заканчивающееся \ или /
      // *        - любое количество раз
      // )        - закончилась группа пути
      // (.+)[.]  - группа имени файла - от 1 до бесконечности любых символов заканчивается точкой
      // ([^.]+)  - группа расширения - любые символы кроме точки от одного до бесконечности
      val r = """(.*[\/\\])*(.+)[.]([^.]+)""".r
      val r(p, n, e) = s
      Some(p, n, e)
    }
  }
  val RichFile(path, name, extension) = """C:\Users\PROFESIONAL\IdeaProjects\Chapter_11\src\main\scala\Exercise_6.scala"""
  println(path + "\n" + name + "\n" + extension)
}
