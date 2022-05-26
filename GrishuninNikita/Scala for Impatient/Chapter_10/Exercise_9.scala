import java.io

/**
 * В библиотеке java.io имеется возможность добавить буферизацию
 * в поток ввода с помощью декоратора BufferedInputStream.
 * Реализуйте буферизацию как трейт. Для простоты переопределите метод read.
 */
object Exercise_9 extends App {
  trait BufferedInputStream extends java.io.InputStream {
    private val in = new io.BufferedInputStream(this, 20)
    override def read = in.read
  }
  val is = new java.io.FileInputStream("C:\\Users\\PROFESIONAL\\IdeaProjects\\Chapter_10\\src\\main\\scala\\exercise_9.txt") with BufferedInputStream
  var data = 0
  while(data != -1) data = is.read
}

