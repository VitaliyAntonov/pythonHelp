/**
 * Выполните предыдущее упражнение, используя неизменяемый ассоциативный массив
 */

import java.util.Scanner
import scala.collection.mutable.ArrayBuffer


object Exercise_3 extends App{
  val in = new Scanner(new java.io.File("C:\\Users\\PROFESIONAL\\IdeaProjects\\Chapter_4\\src\\main\\scala\\file.txt"))
  var words = ArrayBuffer[String]()
  while(in.hasNext()) words += in.next() // Добавление в буфер всех слов
  var wordsCount = new scala.collection.immutable.HashMap[String, Int]
  for (word <- words.distinct) wordsCount = wordsCount + (word -> words.count(_ == word))// Подсчет повторяющихся слов в буфере
  println(wordsCount.mkString(", "))
}
