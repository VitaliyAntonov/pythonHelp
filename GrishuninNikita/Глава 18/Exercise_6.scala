/**
 * Напишите обобщенный метод middle, возвращающий средний элемент из любого экземпляра Iterable[T].
 * Например, вызов middle("World") должен вернуть 'r'.
 */

object Exercise_6 extends App {
  def middle[T](a: Iterable[T]) = {
    a.drop(a.size / 2).head
  }
  println(middle("World"))
}
