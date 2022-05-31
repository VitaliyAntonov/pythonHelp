package lectures.week3fp

object FunctionsFP extends App{
  // Функциональное программирование - это написание кода с использованием только чистых функций и неизменяемых переменных
  // Чистая функция(pure function) - это когда
  //результат работы функции зависит только от того, что она получает на вход, и описанного внутри нее алгоритма. А значит, сколько бы раз такая функция ни была вызвана, например, для параметра х - результат ее работы будет неизменным
  //нет ни чтения, ни записи в файл или любого другого взаимодействия с внешним источником данных (файлом, базой данных, UI)

  // Функции
  val product = new Function1[Int, Int]{
    // Function1[A, B] - A - тип передаваемого значения, B - тип возвращаемого значения
    // Присваем переменной экземпляр трейта Function(он уже прописан в scala) с номером(0-22), соответствующим количеству передаваемых параметров
    // Трейт Function имеет вид trait Function1[A, B] def apply(x: A): B
    override def apply(x: Int): Int = x * 2
  } // Это называется анонимные функции

  val product2 = (x: Int) => x*2 // Альтернативная запись которая является синтаксическим сахаром
  // Существует несколько вариантов записи анонимных функций
  // Например
  val product3: Int => Int = _ * 2
  val product4: (Int, Int) => Int = _ * _
  val product5 = (_: Int) * (_: Int)
  val factorial: Int => Int = (n: Int) => // При объявлении функий использующих рекурсию, необходимо явно указывать тип возвращаемого значения
    if (n == 0) 1 else n * factorial(n-1)

  // Функции высшего порядка
  // Под функциями высшего порядка понимают такие функции, которые на вход получают другую функцию или же, как результат, возвращают функцию.
  def nTime(f: Int => Int, x: Int, n: Int): Int = { // Функция принимающая другую функцию f и применующую её n раз к x
    if (n <= 0) x
    else nTime(f, f(x), n - 1)
  }
  val increment = (x: Int) => x + 1
  val b = nTime(increment, 0, 5)

  // Каррированные функции
  // Каррирование это функция которая на вход принимает несколько аргументов, а в теле этой функции происходит серия вызово функций,
  // каждая из которых принимает единственный аргумент
  def add(x: Int, y: Int) = x + y
  println(add(1, 2)) // 3

  def add1(x: Int) = (y: Int) => x + y
  println(add1(1)(2)) // 3

  def add2(x: Int)(y: Int) = x + y
  println(add2(1)(2))

  // Второй способ написания функии nTime
  def curryingNTimes(f: Int => Int, n: Int): Int => Int ={
    if (n <= 0) (x: Int) => x // лямбда-функция, что просто берет и возвращает значение
    else (x: Int) => curryingNTimes(f, n-1)(f(x))
  }
  println(curryingNTimes(increment, 3)(0))
  def someFunc: Int => Function1[Int, Int] = new Function1[Int, Function1[Int, Int]] {
    override def apply(x: Int): Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(y: Int): Int = x + y
    }
  }
  val res = someFunc(1)
  println(res)
  println(res(4))
}
