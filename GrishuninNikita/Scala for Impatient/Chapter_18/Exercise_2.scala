/**
 * Определите изменяемый класс Pair[T] с методом swap,
 * который меняет компоненты пары местами.
 */

object Exercise_2 extends App {
  class Pair[T](var first: T, var second: T){
    def swap ={
      val tmp = second
      second = first
      first = tmp
      this
    }
  }
}
