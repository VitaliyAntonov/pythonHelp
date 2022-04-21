/**
 * Напишите функцию lteqgt(values: Array[Int], v: Int),
 * возвращающую тройку, содержащую счетчик значений, меньших v,
 * равных v и больших v.
 */

object Exercise_9 extends App{
  def lteqgt (values: Array[Int], v: Int): Unit = {
    var more, small, equals  : Int = 0
    for (i <- 0  until values.length) {
      if(values(i) > v) more += 1
      else if (values(i) < v) small += 1
      else equals += 1
    }
    println("Больше: " + more + " Меньше: " + small + " Равно: " + equals )
  }
  val arr = Array(1, 3, 4, 5, 2,-2)
  lteqgt(arr, 3)
}
