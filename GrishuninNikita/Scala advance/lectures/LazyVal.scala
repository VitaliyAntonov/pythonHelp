package lectures

object LazyVal {
  // Ленивые вычисления полезны тем, что значения переменных не нужно вычислять, если эти переменные не будут использоваться.
  // Смотрите, если напишем вот так:
  val someVal = throw new RuntimeException // ничего хорошего в нашей программе не случится - но ничего хорошего и не ожидалось.
  // Зато если добавим ключевое слово lazy и напишем вот так:
  lazy val someVal2 = throw new RuntimeException
  // В этом случае наша программа прекрасно отработает, если значение someVal нигде не будет использовано в коде, т.к. тогда не будет надобности его вычислять.
  // Кстати, запомните, ленивые вычисления подходят только для val. Если попытаемся использовать lazy совместно с var, то получим ошибку
  // Про ленивые вычиления известно еще и то, что как только значение переменной было вычислено, оно не меняется.

  // lazy и вызов по необходимости (call by need)
  // При вызове  по необходимости значение переменной вычисляется только один раз и сохраняется для всех последующих вызовов.
  def callByName(n: => Int): Int = n * n * n

  def someLongComputation: Int = {
    println("long computation") // long computation будет выведено на экран три раза
    2
  }

  println(callByName(someLongComputation))

  // в таких ситуациях лучше использовать вызов по необходимости, достигаемый за счет использования lazy.
  def someCallByName(n: => Int): Int = {
    lazy val lazyVal = n
    lazyVal * lazyVal * lazyVal
  }

  def someSomeLongComputation: Int = {
    println("long computation") // выведется один раз
    2
  }

  println(someCallByName(someSomeLongComputation))


  // Разница между filter и withFilter

  // Когда требуется отфильтровать значения из коллекции, можно применить как filter, так и withFilter.
  // Главное - понимать, что для применения нескольких фильтрационных критериев лучше подходит  withFilter
  // (так как мы меньше раз проходимся по коллекции, чем если бы применяли filter),
  // но срабатывать он будет только при дополнительном применении foreach, map или flatMap.

  def greaterThanTen(i: Int): Boolean = {
    println(s"проверяем если $i > 10")
    i > 10
  }
  def smallerThanTwenty(i: Int): Boolean = {
    println(s"проверяем если $i < 20")
    i < 20
  }

  val aList = List(1, 6, 15, 100, 17)
  val filteredList = aList
    .filter(greaterThanTen) // Возвращаем aList > 10
    .filter(smallerThanTwenty) // Возвращаем aList < 20
  println(filteredList) // List(15, 17)

  val lazyFilteredList = aList
    .withFilter(greaterThanTen)
    .withFilter(smallerThanTwenty)
  println(lazyFilteredList) // Останется неизменным от aList
  lazyFilteredList.foreach(println) // Чтобы сработал надо применить foreach

}
