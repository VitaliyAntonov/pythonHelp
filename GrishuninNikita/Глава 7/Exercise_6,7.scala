/**
 *   Напишите программу, копирующую все элементы из Java-хеша в Scala-хеш.
 *   Используйте операцию импортирования для переименования обоих классов.
 *   Перенесите все инструкции import в самую внутреннюю область видимости, насколько это возможно.
 */

package com {
  class convert(a: String, b: Int) {
    import java.util.{HashMap => JavaHashMap}
    import scala.collection.mutable._
    import scala.jdk.CollectionConverters._
    val k = new JavaHashMap[String,Int]
    k.put(a, b)
    def copy (): Map[String, Int] ={
      k.asScala
    }
  }
}
object Exercise_6 extends App{
  val conv = new com.convert("Nikita", 312)
  val r = conv.copy()
  println(r)
}