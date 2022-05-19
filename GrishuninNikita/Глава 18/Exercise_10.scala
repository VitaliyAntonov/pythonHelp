/**
 * Для изменяемого класса Pair[S, T] используйте механизм ограничения типа,
 * чтобы определить метод swap, который можно вызывать с параметрами одного типа
 */

object Exercise_10 extends App {
  class Pair[T, S](var first: T, var second: S){
    def swap()(implicit ev: T =:= S) ={
      val tmp = first
      first = second.asInstanceOf[T]
      second = tmp
      this
    }
  }
}
