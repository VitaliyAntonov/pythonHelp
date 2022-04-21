/**
 * Выведите таблицу всех Java-свойств.
 */


import scala.jdk.CollectionConverters._

object Exercise_7 extends App{
  val props : scala.collection.Map[String, String] = System.getProperties().asScala
  var size = 0
  for(p<- props){
    if(p._1.length > size) size = p._1.length // Поиск размера самого длинного ключа
  }
  for(p<- props){
    println(p._1 + " " * (size - p._1.length) + " | " + p._2) // Выводе таблицы
  }
}
