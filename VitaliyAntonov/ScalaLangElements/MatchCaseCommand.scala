package ScalaLangElements


/** Скала для нетерпеливых
 * Глава 14
 * Сопоставление с образцом
 * */

object MatchCaseCommand extends App {

  /** Работа match с массивом */
  val arr = Array(2, 2, 3,1,5)

  arr match {
    case Array(0) => println("Array  0")
    case Array(x, y) => println(s"Array  $x $y")
//    case Array(1, _*) => println("1 ...")
    case Array(x, rest @ _*) => {
      println("Array  rest.min: " + rest.toArray.min)
    }
    case _ => println("Array  something else")
  }

  /** Работа match со списком */
  val lst = List(1, 2, 3, 4)

  lst match {
    case 0 :: Nil => println("List  0")
    case x :: y :: Nil => println(s"List  $x $y")
    case 0 :: tail => {
      print("List  ")
      tail.foreach(x => print(s"$x "))
      println("0 ...")
    }
    case _ => println("List  something else")
  }

  /** match с кортежем */
//  val pair = Tuple2(99, "Luftballons")
  val pair = Tuple2("Luftballons", 0)


  pair match {
    case ("0", _) => println("Tuple2  0 ...")
    case (y, 0) => println(s"Tuple2  $y 0")
    case _ => println(s"Tuple2  neither is 0 (${pair._1}, ${pair._2})")

  }

  /** 14.7. Образцы в объявлениях переменных */

  //образцы можно использовать в объявлениях
  //переменных. Например
  val (x, y) = (1, 2)

  // Такой прием удобно использовать с функциями, возвращающими
  // пары значений, например
  val (q, r) = BigInt(10) /% 3

  // присвоит первый и второй элементы массива arr переменным first
  // и second, а остальные элементы – последовательности rest
  val Array(first, second, rest @ _*) = arr

  /** 14.8. Образцы в выражениях for */
  import scala.collection.JavaConversions.propertiesAsScalaMap
  // Преобразование Java Properties
  // в ассоциативный массив Scala – только ради примера
  println("\n")
  for ((k, v) <- System.getProperties())
    println(k + " -> " + v)
  println("\n")


  /** ------------ 14.9. Case-классы и сопоставление с образцом -------------- */

  /** В следующем примере определяются два case-класса, наследующих обычный
   * класс (не являющийся case-классом): */
  abstract class Amount
  case class Dollar(value: Double) extends Amount
  case class Currency(value: Double, unit: String) extends Amount

  /** Можно также определять case-объекты: */
  case object Nothing extends Amount

  /** При наличии объекта Amount можно воспользоваться операцией
   * сопоставления с образцом, чтобы определить тип валюты и присвоить
   *  значения свойств переменным: */

  val amt = Dollar(1)
  val cur = Currency(1.0, " Рубль ")

  println(amtMatch(amt))
  println(amtMatch(cur))

  def amtMatch(amt: Amount) = {
    amt match {
      case Dollar(v) => s"$$$v"
      case Currency(_, u) => s"Oh noes, I got $u"
      case Nothing => ""
    }
  }


  /** -------------- 14.10. Метод copy и именованные параметры ------------- */


  /** Метод copy case-класса создает новый объект с теми же значениями полей,
   * что и в существующем. Например: */
  val amt1 = Currency(29.95, "EUR")
  val price = amt1.copy()

  /** используя именованные параметры, можно изменять некоторые свойства: */
  val price1 = amt1.copy(value = 19.95) // Currency(19.95, "EUR")
  val price2 = price1.copy(unit = "CHF") // Currency(29.95, "CHF")

  println(price1)
  println(price2)


  /** 14.11. Инфиксная нотация в предложениях case  */
//  case class ::[E](override val head: E, override val tail: List[E]) extends List[E]
  val hd = 1
  val tl = List(2,3,4)
  println(hd::tl)

  /** 14.12. Сопоставление с вложенными структурами  */

  /**  товары, продаваемые в магазине. Иногда они объединяются для предоставления скидки. */
  abstract class Item
  case class Article(description: String, price: Double) extends Item
  case class Bundle(description: String, discount: Double, items: Item*) extends Item

  /** создание вложенных объектов: */
  val testBun = Bundle("Father's day special", 20.0,
    Article("Scala for the all", 39.95),
    Bundle("Anchor Distillery Sampler", 10.0,
      Article("Old Potrero Straight Rye Whiskey", 79.95),
      Article("Junípero Gin", 32.95)))

  inMatch(testBun)

  /** В образцах можно организовать сопоставление с конкретным вложением, например */
  def inMatch(x: Item) = {
      x match {
        /** присвоит переменной descr описание первого товара в пакете. */
  //      case Bundle(_, _, Article(descr, _), _*) => println(descr)
        /** При желании присвоить вложенное значение переменной можно с помощью аннотации @: */
        case Bundle(_, _, art @ Article(_, _), rest @ _*) => println("art = " + art + "  rest = " + rest)
        case _ =>
      }
    }

  /** Как приложение ниже приводится функция, вычисляющая стоимость товара: */
//  def price(it: Item): Double = it match {
//    case Article(_, p) => p
//    case Bundle(_, disc, its @ _*) => its.map(price _).sum - disc
//  }

  /** 14.14. Запечатанные классы
   * Все подклассы запечатанного класса должны объявляться в том же файле, что и сам класс.*/
  sealed abstract class Amount1
  case class Dollar1(value: Double) extends Amount1
  case class Currency1(value: Double, unit: String) extends Amount1

  /**
   * --------------   14.15. Имитация перечислений   ---------------
   * Case-классы позволяют имитировать перечислимые типы в Scala. */

  /** суперкласс объявлен как запечатанный(sealed).
   * Это позволяет компилятору убедиться в полноте выражения match. */
  sealed abstract class TrafficLightColor

  case object Red extends TrafficLightColor
  case object Yellow extends TrafficLightColor
  case object Green extends TrafficLightColor
  def getRules(color: TrafficLightColor) = color match {
    case Red => "stop"
    case Yellow => "hurry up"
    case Green => "go"
  }

  /** ------------------- 14.16. Тип Option ----------------- */

  val scores = Map("Alice" -> 22, "Fred" -> 30)

  /** Метод get класса Map возвращает Option.
   * Если для указанного ключа отсутствует значение, метод get вернет None.
   * В противном случае он завернет возвращаемое значение в Some. */
  val alicesScore = scores.get("Alice")
  alicesScore match {
    case Some(score) => println(score)
    case None => println("No score")
  }

  /** Более удачное решение дает метод getOrElse: */
  println(alicesScore.getOrElse("No score"))


  /** --------------- 14.17. Частично определенные функции ---------------- */

  /** Множество предложений case, заключенных в фигурные скобки,
   * образует частично определенную функцию (partial function) – функ-
   * цию, которая может быть определена не для всех входных значений.
   * Такие функции являются экземплярами класса PartialFunction[A, B].
   * (A – тип параметра, B – тип возвращаемого значения.) Этот класс
   * имеет два метода: apply, вычисляющий значение функции из сопо-
   * ставления с образцом, и isDefinedAt, возвращающий true, если вход-
   * ное значение совпадает хотя бы с одним образцом.
   */
  val f: PartialFunction[Char, Int] = { case '+' => 1 ; case '-' => -1 }
  println(f('-')) // Вызов f.apply('-'), вернет -1
  println(f.isDefinedAt('0')) // false
//  f('0') // Возбудит исключение MatchError

  val rez0 = "-3+4".collect { case '+' => 1 ; case '-' => -1 } // Vector(-1, 1)


  /**
   *  Когда регулярное выражение имеет группы,
   *  с помощью экстрактора образца можно выполнить сопоставление
   *  для каждой группы. Например:
   */
  val pattern = "([0-9]+) ([a-z]+)".r
  "99 bottles" match {
    case pattern(num, item) => println(s"Regex  num = $num   item = $item")
    case _ =>
    // num получит значение "99", а item – "bottles"
  }



  /** ============== УПРАЖНЕНИЯ ================== */


  /**
   * Используя сопоставление с образцом, напишите функцию
   * swap, которая принимает пару целых чисел и возвращает ту
   * же пару, поменяв компоненты местами.
   */
  def swap(a:Int, b:Int): (Int, Int) = {
    Tuple2(a, b) match{
      case (a1, b1) => Tuple2(b1, a1)
      case _ => Tuple2(a, b)
    }
  }

}

