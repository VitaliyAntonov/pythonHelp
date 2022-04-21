/**
 * Выполните предыдущее упражнение, используя сортированный ассоциативный массив,
 * чтобы слова выводились в отсортированном порядке
 * Выполните предыдущее упражнение, используя java.util.TreeMap, адаптировав его для работы со Scala API.
 */

import java.util.Scanner
import scala.collection.mutable.ArrayBuffer
import scala.collection.immutable._
object Exercise_4_5 extends App{
  val in = new Scanner(new java.io.File("C:\\Users\\PROFESIONAL\\IdeaProjects\\Chapter_4\\src\\main\\scala\\file.txt"))
  var words = ArrayBuffer[String]()
  while(in.hasNext()) words += in.next() // Добавление в буфер всех слов
  var wordsCount = new scala.collection.immutable.HashMap[String, Int]
  for (word <- words.distinct) wordsCount = wordsCount + (word -> words.count(_ == word)) // Подсчет повторяющихся слов в буфере
  val srt = TreeMap(wordsCount.toArray:_*) //.toArray создает Array[Turple3[Int, String]], : _* сообщает компилятору, что содержимое массива следует рассматривать как повторяющиеся параметры.
  println(srt)
}
