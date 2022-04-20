/**
 * Представьте, что имеется буфер целых чисел и вам требуется удалить все отрицательные значения,
 * кроме первого. Ниже приводится последовательное решение, устанавливающее
 * флаг, когда встречается первое отрицательное число, после
 * этого удаляются все отрицательные элементы, находящиеся дальше в буфере.
 * Перепишите его на языке Scala, сначала собрав все позиции отрицательных
 * элементов, затем перевернув последовательность и вызвав a.remove(i) для каждого индекса.
 */
import scala.collection.mutable.ArrayBuffer
object Exercise_8 extends App {
  val arr = ArrayBuffer(1, -22, -5, 4, -2, 6, -22)
  val ind = (for(i <- 0 until arr.length if arr(i) < 0) yield i).sorted.reverse
  for(i<- 0 until ind.length)
    if(i!= ind.length - 1) arr.remove(ind(i))
  println(arr.mkString(", "))
}
