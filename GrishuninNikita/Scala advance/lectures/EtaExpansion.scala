package lectures

object EtaExpansion {
  // Если нам необходимо сложить два числа, то код для этого можно написать несколькими способами:
  //
  //Каррированный метод:
  def curriedAdder(x: Int)(y: Int): Int = x + y
  println(curriedAdder(2)(3))
  // Но если мы знаем, что первым аргументом всегда будет 2, то можно сделать так:
  val addTwo: Int => Int = curriedAdder(2)
  println(addTwo(3)) // 5
  // Еще один способ сделать лифтинг - использовать нижнее подчеркивание на конце:
  val addTwo2 = curriedAdder(3) _
  // когда выполняется вот такой код, на самом деле происходит Eta-расширение (и даже _ не требуется):
  def add(x: Int) = x + 1
  List(1, 2, 3).map(add) // Eta-expansion: List(1, 2, 3).map(x => add(x))
}
