package lectures.week3fp

object Collections {
  // Set - коллекция элементов одного типа, не изменяемая по умолчанию
  val emptySet: Set[Int] = Set()
  val aSet = Set(10, 20, 30, 40)
  val anotherSet = Set(30, 40, 50, 60)

  aSet.isEmpty // false
  emptySet.isEmpty // true

  aSet.head // 10
  aSet.tail // Set(20, 30, 40)

  aSet.min // 10
  aSet.max // 40

  aSet.intersect(anotherSet) // Set(30, 40)
  aSet.&(anotherSet) // Set(30, 40)

  aSet.++(anotherSet) // HashSet(10, 20, 60, 50, 40, 30)
  aSet ++ anotherSet // HashSet(10, 20, 60, 50, 40, 30)

  // Seq
  val aSequence = Seq(1, 2, 3, 4)
  println(aSequence) // List(1, 3, 2, 4) получается Seq представляет из себя List

  aSequence.length // 4

  aSequence ++ Seq(6, 7, 5) // List(1, 3, 2, 4, 6, 7, 5)

  aSequence.reverse // List(4, 2, 3, 1)
  aSequence.sorted // List(1, 2, 3, 4)

  aSequence(1) // 3 получение элемента по индексу
  aSequence.search(3) // Found(1) возвращает индекс найденного элемента

  // Map хранит пары ключ-значение
  val aMap: Map[String, Int] = Map() // создание пустого map
  val colors: Map[String, String] = Map(("black", "#00000"), "blue" -> "#77273").withDefaultValue("N/A")
  // withDefaultValude - помогает избежать NoSuchElementException, если такого ключа нет
  // Проверка есть ли в map ключ
  println(colors.contains("black")) // вернет true
  println(colors("black")) // вернет значение по ключу
  val color: (String, String) = "green" -> "#339616" // добавление новой пары
  val newColors: Map[String, String] = colors + color

  println(colors.toList)
  println(List(("White", "#ffffff")).toMap) // Map(White -> #ffffff)

  // Array
  val anArray: Array[String] = Array("h", "e", "l", "l", "p", ".")
  anArray(5) = "!" // замена элемента по индексу
  val twoElements: Array[Boolean] = Array.ofDim[Boolean](2) // пустой массив размер 2
  twoElements.foreach(println) // false, false
  val numbersSeq: Seq[String] = anArray // преобразуют тип
  println(numbersSeq) // ArraySeq(h, e, l, l, o, !)

  // Tuple содержит элементы разных типов
  val aTuple: (Int, String) = (100, "Scala")
  val sameTuple: (Int, String) = Tuple2(100, "Scala") // Несколько способов создания
  // Tuple так же как Function до 22 элементов
  println(aTuple) // (100, Scala)
  aTuple._1 // 100
  aTuple._2 // Scala
  val copy: (Int, String) = aTuple.copy(_2 = "Python") // копирование с заменой элемента
  aTuple.swap // Scala, 100

  // Range
  val aRange: Seq[Int] = 1 until 3 // число 3 не включено
  aRange.foreach(print) // 12
  (1 to 3).foreach(x => print("Hello")) // HelloHelloHello можно использовать вместо рекурсии
  val aRangeToVector: Vector[Int] = (1 to 5).toVector
  println(aRangeToVector) // Vector(1, 2, 3, 4, 5)

  // foreach
  val list = List(1, 2, 3)
  list.foreach(print) // foreach тот же map только на вход подаются функции возвращающие Unit

  // map, flatMap, filter
  // Смысл map заключается в том, что заданная функция применяется к каждому элементу списка.
  // flatMap очень похож на map, только он преобразует каждый элемент в целый список элементов и выполняет действия уже с ними, а потом результат собирает в одно целое.
  val fruits = List("apple", "banana")

  val mapResult = fruits.map(_.toUpperCase)
  val flatResult = fruits.flatMap(_.toUpperCase)

  println(mapResult) // List(APPLE, BANANA)
  println(flatResult) // List(A, P, P, L, E, B, A, N, A, N, A)
  // Именно из-за того, как работает flatMap, если нам требуется проставить точку после каждого символа строки и на выходе получить модифицированную строку, использовать придется именно его.
  val s = "Hello"
  val newStr: String = s.flatMap(c => (c + "."))
  println(newStr) // H.e.l.l.o.
  // map тоже сработает, только вернет уже не строку
  println(s.map(c => (c + "."))) // ArraySeq(H., e., l., l., o.)
  // Комбинируя map и flatMap, мы получаем возможность пройтись по списку. Альтернативой является применение for
  val list1 = List(1, 2)
  val list2 = List("a", "b")
  val combinations = list1.flatMap(n => list2.map(c => c + n)) //комбинируем list и list 2
  println(combinations) // List(a1, b1, a2, b2)
  // аналогичный код с for
  val forCombination = for {
    n <- list1
    c <- list2
  } yield c + n

  list1.filter(_ > 1).flatMap(n => list2.map(c => c + n)) // элемента из list1 должны быть больше 1
  // аналогично с for
  val forFilterCombination = for {
    n <- list1 if n > 1
    c <- list2
  } yield c + n
 }

