/**
 * Используя трейты журналирования из этой главы, добавьте
 * поддержку журналирования в предыдущее упражнение, чтобы продемонстрировать процесс буферизации
 */
object Exercise_10 extends App {
  trait ConsoleLogger{
    def log(msg: String) = println(msg)
  }
  trait BufferedInputStream extends java.io.InputStream with ConsoleLogger {
    private val bis = new java.io.BufferedInputStream(this, 50) {
      override def read: Int = {
        log(buf.map(_.toChar).mkString)
        super.read
      }
    }
    override def read: Int = {
      bis.read
    }
  }
  val is = new java.io.FileInputStream("C:\\Users\\PROFESIONAL\\IdeaProjects\\Chapter_10\\src\\main\\scala\\exercise_9.txt") with BufferedInputStream
  var data = 0
  while(data != -1) data = is.read
}

