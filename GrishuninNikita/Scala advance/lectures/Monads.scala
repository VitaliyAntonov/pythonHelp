package lectures

object Monads {
  // Важно запомнить, что монады - это всего лишь концепция, а никак не типы или структуры данных.
  // Обычно упоминают о двух основных операциях, доступных для монад:
  //unit - позволяет сконструировать монаду из одной либо нескольких переменных.
  //Например, сконструировать список из значений 1, 2, 3 мы можем посредством List(1, 2, 3)
  //flatMap - должен быть вам знаком из темы коллекций

  // На монады распространяются три закона:
  // Закон левой идентичности (left-identity): если взять элемент и превратить его в монаду, то применение flatMap (вызывающего функцию f)
  // к такой монаде должно выдавать результат применения функции f к элементу монады.
  // В общем виде закон записывается вот так: unit(x).flatMap(f) = f(x).
  // Если же написать этот закон для списка, то получим List(x).flatMap(f) = f(x).
  val intList = List(1)
  def toDouble(int: Int): List[Double] = List(int.toDouble)
  val doubleList = intList.flatMap(toDouble)
  println(doubleList) // 1.0 - функцию toDouble применили к элементу 1

  // закон правой идентичности (right-identity): если к монаде применить flatMap, вызывающий unit, то на выходе должна получиться та же самая монада.
  // Общий вид закона: aMonad.flatMap(unit) = aMonad.
  intList.flatMap(x => List(x)) // получим изначальный список List(1)

  // закон ассоциативности (associativity): если к монаде сначала применить flatMap, вызывающий функцию f, затем применить flatMap, вызывающий функцию g,
  // то полученный результат аналогичен тому, что мы бы получили, если бы применили flatMap,
  // вызывающий составную функцию: aMonad.flatMap(f).flatMap(g) = aMonad(x => f(x).flatMap(g))
  def increment(int: Double): List[Double] = List(int + 1)
  val res1 = intList.flatMap(toDouble).flatMap(increment)
  val res2 = intList.flatMap(x => toDouble(x).flatMap(increment))
  println(res1) // List(2.0)
  println(res2) // List(2.0)
}
