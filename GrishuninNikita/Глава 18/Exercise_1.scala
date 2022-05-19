/**
 * Определите неизменяемый класс Pair[T, S] с методом swap,
 * возвращающим новую пару, где компоненты поменяны местами.
 */

object Exercise_1 extends App {
  class Pair[T, S](val first: T, second: S){
    def swap = new Pair[S, T](second, first)
  }
}
