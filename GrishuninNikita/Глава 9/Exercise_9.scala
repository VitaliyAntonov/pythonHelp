/**
 * Напишите программу на Scala, которая подсчитывает количество файлов с расширением .class
 * в указанном каталоге и во всех его подкаталогах.
 */
object Exercise_9 extends App {
  import java.nio.file._
  val dirname = "/home/cay/scala-impatient/code"
  val entries = Files.walk(Paths.get(dirname))

}
