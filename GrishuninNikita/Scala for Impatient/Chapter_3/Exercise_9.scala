/**
 * Улучшите решение из предыдущего упражнения.
 * Соберите индексы элементов, подлежащих перемещению и позиции, куда они должны быть помещены.
 * Переместите их и укоротите буфер. Не копируйте элемент
 */
import scala.collection.mutable.ArrayBuffer

object Exercise_9 extends App {
  val arr = ArrayBuffer(1, -22, -5, 4, -2, 6, -22)
  val ind = (for(i <- 0 until arr.length if arr(i) < 0) yield i).sorted.reverse
  for(i<- 0 until ind.length)
    if(i!= ind.length - 1) arr.remove(ind(i))
  println(arr.mkString(", "))
}
