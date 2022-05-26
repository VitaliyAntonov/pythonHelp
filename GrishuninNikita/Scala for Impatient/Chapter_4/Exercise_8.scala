/**
 * Напишите функцию minmax(values: Array[Int]), возвращающую
 * пару, содержащую наименьшее и наибольшее значения.
 */

import scala.jdk.CollectionConverters._

object Exercise_8 extends App{
  def minmax (values: Array[Int]): Unit = {
    var max, min : Int = 0
    for (i <- 0  until values.length) {
      if(values(i) > max) max = values(i) // Поиск максимального значения
      else if (values(i) < min) min = values(i) // Поиск минимального значения
    }
    println(max,min)
  }
  val arr = Array(2,3,4,5,-888,-2)
  minmax(arr)
}
