import scala.math.sqrt

/**
 * На первый взгляд, кажется странной необходимость ограничивать параметры метода неизменяемого класса Pair[+T].
 * Но представьте, что в Pair[T] можно написать такое определение метода: def replaceFirst(newFirst: T)
 * Проблема в том, что подобный метод можно переопределить не совсем правильным способом.
 * Придумайте пример проблемы. Напишите подкласс NastyDoublePair класса Pair[Double],
 * переопределяющий метод replaceFirst, который создает пару,
 * где первый элемент является результатом извлечения квадратного корня из аргумента newFirst.
 * Затем сконструируйте вызов метода replaceFirst("Hello") типа Pair[Any],
 * который в действительности является типом NastyDoublePair.
 */

object Exercise_9 extends App {
  class Pair[T](val first: T, val second: T){
    def replaceFirst(newFirst: T) = new Pair[T](first, second)
  }
  class NastyDoublePair(first: Double, second: Double) extends Pair[Double](first, second){
    override def replaceFirst(newFirst: Double) = new NastyDoublePair ((sqrt(newFirst)), second)
  }
  val a = new NastyDoublePair(25.0, 3.0)
  val b = new Pair("asd", "sd")
  b.replaceFirst("Hello")
  // Не очень понял формулировку задания
}
