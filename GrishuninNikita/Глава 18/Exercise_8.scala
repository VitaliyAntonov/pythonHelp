/**
 * В разделе 18.10 «Ко- и контравариантные позиции» в методе replaceFirst определена граница типа.
 * Почему нельзя определить эквивалентный метод для изменяемого класса Pair[T]?
 * Компилятор отвергнет такое объявление, потому что тип T параметра находится в контравариантной позиции.
 * Но этот метод не может повредить существующую пару, потому что возвращает новую пару.
 */

object Exercise_8 extends App {
  // def replaceFirst[R >: T](newFirst: R) { first = newFirst } // Ошибка
}
