/**
 * Определите операцию unapplySeq для класса RichFile, извлекающую все сегменты пути.
 * Например, для файла /home/cay/readme.txt должна быть возвращена последовательность из трех
 * сегментов: home, cay и readme.txt
 */
object Exercise_10 extends App {
  object RichFile{
    def unapplySeq(s: String): Option[Seq[String]] = {
      if (s.trim == "") None
      else Some(s.split("""[\/|\\]""").filter(_!=""))
    }
  }
  val RichFile(s @ _*) = """C:\Users\PROFESIONAL\IdeaProjects\Chapter_11\src\main\scala\Exercise_6.scala""" // s присвается некая последовательность
  println(s.toString)
}
