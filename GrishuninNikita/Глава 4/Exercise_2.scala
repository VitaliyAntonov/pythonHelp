/**
 * Напишите программу, читающую слова из файла.
 * Используйте изменяемый ассоциативный массив для подсчета вхождений каждого слова.
 */

import java.util.Scanner

object Exercise_2 extends App{
  val in = new Scanner(new java.io.File("C:\\Users\\PROFESIONAL\\IdeaProjects\\Chapter_4\\src\\main\\scala\\file.txt"))
  val words = new scala.collection.mutable.HashMap[String, Int]
  while(in.hasNext()){
    var k = in.next() // Переменная хранящая слово
    words(k) = words.getOrElse(k, 0) + 1 // Счетчик слов
  }
  println(words.mkString(", "))
}
