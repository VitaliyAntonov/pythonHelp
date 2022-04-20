/**
 * Как бы вы вычислили среднее значение элементов массива
 * Array[Double]?
 */
import scala.collection.mutable.ArrayBuffer

object Exercise_5 extends App {
val arr = Array(2.2,1.5,5.2,3.6,3.1)
  var avg : Double = 0
  for (i <- 0 until arr.length){
  avg += arr(i)
  }
  avg = avg/arr.length
  println(avg)
}
