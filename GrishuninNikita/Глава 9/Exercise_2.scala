/**
 * Напишите программу на языке Scala, которая читает файл
 * с символами табуляции, заменяя их пробелами так,
 * чтобы сохранить правильное расположение границ столбцов,
 * и записывает результат в тот же файл.
 */
object Exercise_2 extends App {
  import scala.io.Source
  import java.io.PrintWriter
  val source = Source.fromFile("C:\\Users\\PROFESIONAL\\IdeaProjects\\Chapter_9\\src\\main\\scala\\txtFiles\\exercise_2.txt", "UTF-8")
  val lines = source.getLines.toArray
  source.close()
  val source2 = new PrintWriter("C:\\Users\\PROFESIONAL\\IdeaProjects\\Chapter_9\\src\\main\\scala\\txtFiles\\exercise_2.txt", "UTF-8")
  val lines2 = lines.mkString.replace("\t", "   ").toArray
  var strln = 0
  for(i <- 0 until lines2.length) {
    if(strln == 12){
      source2.println(lines2(i))
      strln = 0
    }
    else {
      source2.print(lines2(i))
      strln += 1
    }
  }
  source2.close()

}
