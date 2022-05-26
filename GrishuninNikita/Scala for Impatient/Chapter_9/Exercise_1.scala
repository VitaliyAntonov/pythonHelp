/**
 * Напишите на языке Scala код, который размещает строки
 * в файле в обратном порядке (последнюю делает первой и т. д.).
 */
object Exercise_1 extends App {
  import scala.io.Source
  import java.io.PrintWriter
  val source = Source.fromFile("C:\\Users\\PROFESIONAL\\IdeaProjects\\Chapter_9\\src\\main\\scala\\txtFiles\\exercise_1.txt", "UTF-8")
  val lines = source.getLines.toArray.reverse
  source.close()
  val source2 = new PrintWriter("C:\\Users\\PROFESIONAL\\IdeaProjects\\Chapter_9\\src\\main\\scala\\txtFiles\\exercise_1.txt", "UTF-8")
  for (i <- 0 until lines.length)
    source2.println(lines(i))
  source2.close()
}
