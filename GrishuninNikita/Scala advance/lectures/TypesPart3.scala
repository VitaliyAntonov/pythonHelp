package lectures

object TypesPart3 {
  // F-ограниченный полиморфизм
  // F-ограниченный полиморфизм еще называют рекурсивным. Его имплементацию можно часто встретить в API баз данных.
  // Начнем разбираться. Перед нами стоит следующая задача, связанная с типами:

  trait Fruit {
    def buy: List[Fruit]
  }

  class Apple extends Fruit {
    override def buy: List[Fruit] = ??? // но мы хотим в качестве возвращаемого типа List[Apple]
  }

  class Banana extends Fruit {
    override def buy: List[Fruit] = ??? // но мы хотим в качестве возвращаемого типа List[Banana]
  }

  // Т.е. мы хотим заставить метод, ориентированный на работу с супертипом, принимать текущий тип.
  // Данная задача имеет несколько решений.

  // Однако, если мы ошибемся, может получиться вот так:
  //  class Banana extends Fruit {
  //    override def buy: List[Apple] = ??? // а хотели здесь List[Banana]
  //  }

  object Poly{
    // 2 Лучшим решением будет использовать рекурсивные типы или f-ограниченный полиморфизм.
    // Для этого поработаем с параметрами типа.

    trait Fruit[T <: Fruit[T]] { // задали рекурсивный тип
      def buy: List[Fruit[T]]
    }

    class Apple extends Fruit[Apple] {
      override def buy: List[Fruit[Apple]] = ???
    }

    class Banana extends Fruit[Banana] {
      override def buy: List[Fruit[Banana]] = ???
    }

    // В этом случае Fruit[T] будет рекурсивным типом, так как появляется в собственной подписи метода(method signature).
    // Поскольку мы использования рекурсивный тип совместно с ограничением типов - такой подход
    // будет считаться f-ограниченным полиморфизмом.

    // Но и здесь мы не застрахованы от ошибки написать так:
    // class Banana extends Fruit[Apple] { // а нам надо Fruit[Banana]
    //    override def buy: List[Apple] = ???
    //  }
    // Таким образом, нам необходимо гарантировать, что для класса Banana в Fruit[A] - A тоже будет являться Banana.
  }

  object Poly2 {
    // Для решения обозначенной выше проблемы подойдет одновременное применение f-ограниченного полиморфизма и self типов:
    trait Fruit[T <: Fruit[T]] {self: T =>
      def buy: List[Fruit[T]]
    }

    class Apple extends Fruit[Apple]{
      override def buy: List[Fruit[Apple]] = ???
    }

    class Banana extends Fruit[Banana]{
      override def buy: List[Fruit[Banana]] = ???
    }
    // Теперь при смешении типов мы получим предупреждение
    // Но и этот подход не без недостатков. Если продолжить наследование вот так:

    trait PremiumApple extends Apple

    class SuperPremiumApple extends PremiumApple {
      override def buy: List[Fruit[Apple]] = List(new GoldApple) // имеем, Fruit[Apple] а значит, подойдет GoldApple - что нам совершенно не надо
    }

    class GoldApple extends PremiumApple {
      override def buy: List[Fruit[Apple]] = ???
    }
    // Получается, что решение f-ограниченного полиморфизм + self тип эффективно до тех пор,
    // пока иерархия не будет продолжена путем добавления еще одного уровня наследования.
  }

  object TypeClasses {
    // Естественно, и эта проблема решается. Одним из подходов является применение классов типов (type classes).
    trait Fruit

    //
    trait Purchase[A] {
      def buy(fruit: A): List[A]
    }

    class Apple extends Fruit

    object Apple {
      implicit object ApplePurchase extends Purchase[Apple] {
        def buy(fruit: Apple): List[Apple] = ???
      }
    }

    implicit class PurchaseOps[A](fruit: A) {
      def buy(implicit fruitPurchase: Purchase[A]): List[A] = {
        fruitPurchase.buy(fruit)
      }
    }
    val apple = new Apple
    apple.buy
    /**
    теперь срабатывает
    new PurchaseOps[Apple](apple).buy(Apple.ApplePurchase)

    Apple.ApplePurchase - имплиситная переменная, требующаяся
    методу buy

   **/
  }


  // Типы высшего порядка
  // Теперь будем рассматривать ситуацию, когда параметр типа задает другой параметр типа:
  trait HigherKindedType[A[B]]

  // Зачем это надо? Может возникнуть ситуация, когда для разных типов должен применяться один и тот же метод, а дублировать код мы не хотим.
  // Например, если рассмотреть List[A] и Seq[A], станет понятно, что для обоих описанные методы по сути работают одинаково:

  def getSeq[A](a: Seq[A]): Seq[A] = a
  def getList[A](a: List[A]): List[A] = a

  println(getList(List(1, 2, 3)))
  println(getSeq(Seq(1, 2, 3)))

  // Так что возникает необходимость избавиться от избыточного кода.
  // Мы можем два метода для разных коллекций описать одним методом:

  def getCollection[T[_], B](a: T[B]): T[B] = a
  println(getCollection(List(11, 22, 33)))
  println(getCollection(Seq(13, 24, 35)))
}
