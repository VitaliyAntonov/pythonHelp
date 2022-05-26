/**
 * Напишите программу на Scala, которая записывает степени
 * двойки и их обратные величины в файл с экспонентой от 0 до 20.
 */
object Exercise_5 extends App {
  import java.io.PrintWriter
  import math._
  val source = new PrintWriter("C:\\Users\\PROFESIONAL\\IdeaProjects\\Chapter_9\\src\\main\\scala\\txtFiles\\exercise_5.txt", "UTF-8")
  for(i <- 0 to 20) {
    source.println(pow(2,i)+ (" | ") + pow(2, -i))
  }
  source.close()
}
