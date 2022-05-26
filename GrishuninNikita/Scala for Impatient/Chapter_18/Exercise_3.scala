/**
 * Для класса Pair[T, S] напишите обобщенный метод swap,
 * который принимает пару в виде аргумента и возвращает новую пару с компонентами, поменянными местами.
 */

object Exercise_3 extends App {
  class Pair[T, S](var first: T, var second: S){
    def swap[T](pair: Pair[T, S]) = new Pair(pair.second, pair.first)
  }
}
