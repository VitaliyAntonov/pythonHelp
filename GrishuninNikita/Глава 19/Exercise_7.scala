/**
 *  Напишите функцию printValues с тремя параметрами: f, from и to, выводящую все значения f,
 *  для входных значений в заданном диапазоне от from до to. Здесь f должен быть любым
 *  объектом с методом apply, получающим и возвращающим значение типа Int.
 */
object Exercise_7 extends App{
  def printvalues(f: {def apply(i: Int): Int}, from: Int, to: Int): Unit ={
    (from to to).foreach(i=> println(f(i)))
  }
  printvalues(Array(1, 1, 2, 3, 5, 8, 13, 21, 34, 55),3,6)
}

