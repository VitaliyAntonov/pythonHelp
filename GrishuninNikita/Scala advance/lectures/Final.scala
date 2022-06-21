package lectures

object Final {
  // Не используйте:
  // не используйте == 1 при проверке числа на четность / нечетность, проверяйте через n % 2 != 0
  // Причина: не всегда в случае нечетного числа остаток от деления равен 1:
  println(-3 % 2) // -1

  // не используйте == для сравнения Array, используйте sameElements
  // Причина: происходит сравнение не значений, а ссылок:
  print(Array(1) == Array(1)) // false
  println(Array(1).sameElements(Array(1))) // true

  // не используйте == NaN для проверки числа на NaN, используйте .isNan
  // Причина: NaN вообще ничему не равняется, даже себе:
  println(Double.NaN == Double.NaN) // false
  println(Double.NaN.isNaN) // true

  // не используйте .size для проверки коллекции на наличие в ней элементов, используйте .isEmpty
  // Причина: .isEmpty дает большую эффективность, так как позволяет избежать прохождения по всем элементам коллекции
  // не используйте .last при работе с коллекциями, предпочитайте .lastOption
  // не используйте .head при работе с коллекциями, предпочитайте .headOption
  // Причина: если коллекция пуста, вы получите исключение
  println(List.empty[Int].head) // NoSuchElementException
  println(List(1, 2, 3).headOption) // Some(1)
  println(List.empty[Int].headOption) // None

  // не используйте init для получения всех элементов коллекции, кроме последнего, предпочитайте .dropRight(1)
  // не используйте tail для получения всех элементов коллекции, кроме первого, предпочитайте .drop(1)
  // не используйте reduce, предпочитайте .reduceOption
  // Причина: если коллекция пуста, вы получите исключение
  println(List.empty[Int].init) // UnsupportedOperationException
  println(List(1, 2, 3).dropRight(1)) // List(1, 2)
  println(List.empty[Int].dropRight(1)) // List()

  println(List.empty[Int].tail) // UnsupportedOperationException : tail of empty list
  println(List(1, 2, 3).drop(1)) // List(2, 3)
  println(List.empty[Int].drop(1)) // List()

  println(List.empty[Int].reduce(_ + _)) // UnsupportedOperationException
  println(List(1, 2, 3).reduceOption(_ + _)) // Some(6)
  println(List.empty[Int].reduceOption(_ + _)) // None


  // Не используйте return
  // с return у вас нет гарантий, что программа отработает так, как было запланировано:

  // код для получения суммы всех элементов списка
  def add: Int = List(1, 2, 3).foldRight(0)((a, b) => a + b)
  def addR: Int = List(1, 2, 3).foldRight(0)((a, b) => return a + b)
  println(add) // 6
  println(addR) // 3

  // Разница в результатах объясняется тем, что return происходит не для функции в целом, а для метода,
  // в котором return прописан, следовательно, текущие вычисления просто не учитываются.
  // И в примере c addR вы получаете результат сложения числа три с нулем.

  // Кроме того, на самом деле return возвращает тип Nothing. Это легко доказать:
  def x: Int = {
    val someVal: String = return 2
    1
  }
  println(x) // 2
  // Полученный результат свидетельствует о том, что на самом деле тип someVal скорее всего не String, а Nothing.
  // Иначе бы мы получали уведомление о несоответствии типов.

  // Запомните три правила:
  // если что-то может выдать исключения - используем Try
  // если что-то может не сработать - используем Either
  // если чего-то может не быть - используем Option

  // Помните, что в случае исключений не работает referential transparency (это когда результат программы не меняется при замене выражения переменной, содержащей это выражение)
  def foo() = if(1 > 2) throw new RuntimeException else println(2)
  foo() // 2 - все отлично отработало

  def anotherFoo() = {
    val exception = throw new RuntimeException("Oops")
    if (1 > 2) exception  else println(2) // заменили new RuntimeException на переменную exception
  }
  anotherFoo() // RuntimeException

  // Кстати, даже сам код anotherFoo будет помечен, как Unreachable Code


  // При объявлении case class - делайте его final
  // Причина: помогает избежать непредвиденных результатов:
  case class Customer(id: Int)
  class VipCustomer(id: Int, name: String) extends Customer(id)

  println(new VipCustomer(1, "Bob") == new VipCustomer(1, "Alice")) // true

  // В этом примере equals или ==, доступный для case-класса, производит поэлементное сравнение,
  // но только equals ничего не знает о новых аргументах, которые добавились в VipCustomer при наследовании.

}
