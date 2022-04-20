/**
 * Дан массив целых чисел, создайте новый массив, в котором
 * сначала будут следовать положительные значения из оригинального массива,
 * в оригинальном порядке, а за ними отрицательные и нулевые значения, тоже в оригинальном порядке.
 */
import scala.collection.mutable.ArrayBuffer
object Exercise_4 extends App {
  val arr =  ArrayBuffer(1, -2, 3, -4, -5)
  println(arr.mkString(", "))
  val res = (arr.filter(_>0) ++= arr.filter(_<=0)) //.filter - выбирает элементы массива удовлетворяющие условию
  println(res.mkString(", "))
}
