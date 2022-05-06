/**
 * Напишите функцию values(fun: (Int) => Int, low: Int, high:Int),
 * возвращающую коллекцию из значений в указанном диапазоне.
 * Например, вызов values(x => x * x, -5, 5) должен вернуть коллекцию пар
 * (-5, 25), (-4, 16), (-3, 9), ..., (5, 25).
 */

object Exercise_1 extends App{
  def values(fun: (Int) => Int, low: Int, high: Int) =
    (low to high).map(fun) // Возвращает коллекцию чисел с которыми выполняются определенные действия от low до high
  val b = values(x => x*x, -5, 5)
  def values2(fun: (Int) => Int, low: Int, high: Int) =
    (low to high).map(x => Tuple2(x, fun(x))) // Аналогично первой функции, только возвращается Tuple2(Кортеж из двух элементов), x и fun(x)
  val a = values2(x => x*x, -5, 5)
  println(b) //(25, 16, 9, 4, 1, 0, 1, 4, 9, 16, 25)
  println(a.mkString(", ")) //(-5,25), (-4,16), (-3,9), (-2,4), (-1,1), (0,0), (1,1), (2,4), (3,9), (4,16), (5,25)
}
