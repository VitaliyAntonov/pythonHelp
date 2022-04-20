/**
 * Как бы вы переупорядочили элементы массива Array[Int] так,
 * чтобы они следовали в обратном отсортированном порядке?
 * Как бы вы сделали то же самое с буфером ArrayBuffer[Int]?
 */
//С массивом
object Exercise_6 extends App {
  val arr = Array(5, 2, 4, 6, 1)
  val res = for(elem <- arr.reverse.sorted) yield elem
  println(arr.mkString(", "))
  println(res.mkString(", "))
}
//Чтобы сделать тоже самое с буфером нужно только прописать import scala.collection.mutable.ArrayBuffer
//Код останется прежним
