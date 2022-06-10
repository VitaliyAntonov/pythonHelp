package lectures

object Generic {
  // Если написать класс без обобщений, то его методы смогут получать на вход только переменные заранее обозначенного типа. В примере ниже someFunc может получать только переменную типа Int
  class SomeClass {
    def someFunc(aVal: Int): Unit = println(s"integer value $aVal")
  }

  val anInstance = new SomeClass
  anInstance.someFunc(1)

  // Для задания обобщенного класса после имени класса в скобках задается параметр типа:
  class SomeClass2[T] {
    // Тогда вместо конкретного типа, везде прописывается T:
    def someFunc(aVal: T): Unit = println(s"value $aVal")
  }

  // Конкретный тип будет задаваться в момент создания экземпляра класса:
  val anotherInstance = new SomeClass2[String]
  anotherInstance.someFunc("some string")
  val doubleInstance = new SomeClass2[Double]
  doubleInstance.someFunc(2.0)

  // Ограниченные типы
  // Применяются для обеспечения безопасности типов. Рассмотрим верхнее ограничение типа T <: A
  abstract class Customer {
    def isVip: Boolean
  }

  class Regular(val vipStatus: Boolean) extends Customer {
    override def isVip: Boolean = vipStatus
  }

  class Vip(val vipStatus: Boolean) extends Customer {
    override def isVip: Boolean = vipStatus
  }

  class Order[T <: Customer](val person: T) {
    def offer: String = if (person.isVip) "free gift" else "no gift"
  }
  // В коде было использовано верхнее ограничение T <: Customer. Сделано это было по двум причинам:
  // Обеспечение безопасности типов, т.к. мы должны ограничиться только Customer и его подтипами.
  // Если обойтись без ограничения, написав class Order[T](val person: T) , то заказы будут создаваться с person любого типа
  // Если задать просто T, код не запустится, так как метод isVip не будет найден (ошибка value isVip is not a member of type parameter T),
  // ведь T - означает абсолютно любой тип , и будет неизвестно, где именно искать isVip.

  // Нижнее ограничение
  // Чтобы понять, зачем оно нужно, рассмотрим следующую иерархию классов:
  class Client

  class VipClient extends Client

  class Friend extends VipClient
  // Друг вип-клиента (согласно бизнес-логике проектируемого приложения) не обязательно будет нашим клиентом.
  // Если не вводить нижнего ограничения, оставив верхнее, заказы будут приниматься и от Friend, и от Vip
  // Однако это не в наших интересах. Поэтому введем нижнее ограничение. Тогда принять заказ от Friend мы уже не сможем
  // class Order[T >: Vip](val person: T)

  // Контравариантность и ковариантность
  trait Fruit

  class Apple extends Fruit

  class Banana extends Fruit

  // Допустим, мы идем в магазин и наша задача набрать фруктов. Еще раз напомним, что возможно 3 сценария:
  // Инвариантность
  class FruitBasket[T]

  val invariantBasket: FruitBasket[Fruit] = new FruitBasket[Fruit] // Фрукты и только фрукты, никаких apple, banana

  // Ковариантность
  class FruitBasket2[+T]

  val covariantBasket: FruitBasket2[Fruit] = new FruitBasket2[Apple] // И яблоки и бананы

  // Контравариантность
  class FruitBasket3[-T]

  val contravarBasket: FruitBasket3[Apple] = new FruitBasket3[Fruit] // только наследуемые Fruit

  // Возвращаемые типы
  //class FruitStore[-T] {
  //  def show(name: String): T
  //}  Contravariant type T occurs in covariant position in type T of value show
  // Возвращаемые значения ковариантны
  // Решение этой проблемы - возвращение подтипа типа T:
  // def show[B <: T](name: String): B


}
