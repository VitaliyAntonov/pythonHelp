/**
 * Напишите программу на Scala, которая читает текстовый файл,
 * содержащий только вещественные числа, выводит сумму, среднее, максимальное и минимальное значения.
 */
object Exercise_4 extends App {
  import scala.io.Source
  val source = Source.fromFile("C:\\Users\\PROFESIONAL\\IdeaProjects\\Chapter_9\\src\\main\\scala\\txtFiles\\exercise_4.txt", "UTF-8")
  val lines = source.getLines.toArray
  val dbl = for (d <- lines) yield d.toDouble
  var sum : Double = 0
  var max: Double = dbl(0)
  var min: Double = dbl(0)
  var avg: Double = 0
  for(i <- 0 until dbl.length){
    sum += dbl(i)
    if (dbl(i) > max){
      max = dbl(i)
    }
    else if (dbl(i) < min){
      min = dbl(i)
    }
    }
  avg = sum/dbl.length
  println(sum, avg, max, min)
  source.close()
}
