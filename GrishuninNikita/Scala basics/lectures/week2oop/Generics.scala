package lectures.week2oop

object Generics extends App {
  class MyList[A] // [A] - Обощенный тип который будет конкретизирован в момент создания списка, применяются к классам и трейтам
  val listOfStrings = new MyList[String]
  val listOfDoubles = new MyList[Double]
  val listOfInts = new MyList[Int]

  def randomInt(items: List[Int]): Int = { // Метод рандомно выбирающий число из интового списка
    val randomIndex = util.Random.nextInt(items.length)
    items(randomIndex)
  }
  println(randomInt(List(1, 2, 3, 4, 5)))

  def randomItem[A](items: List[A]): A = { // Метод рандомно выбирающий значение из списков любого типа
    val randomIndex = util.Random.nextInt(items.length)
    items(randomIndex)
  }

  // Вариативность
  class Fruit

  class Apple extends Fruit

  class Banana extends Fruit

  class InvariantList[A] // Инвариативность
  val invariantList: InvariantList[Fruit] = new InvariantList[Fruit]
  // Инвариантность диктует, что List[Apple] и List[Fruit] - это совершенно разные вещи, не связанные никакими родственными связями.

  class CovariantList[+A]{ // Ковариативность
    def add[B >: A](element: B) : List[B] = ???
    // Этим кодом мы говорим, что если в список типа A будет добавлен элемент типа B,
    // то список типа A превратится в список типа B, причем B является супер типом для A.
    // То есть мы можем добавить в fruitList[Apple] элемент типа Fruit и тогда список станет fruitList[Fruit]
  }
  val fruitList: CovariantList[Fruit] = new CovariantList[Apple]
  // Ковариантность подразумевает, что раз Apple наследуется от Fruit, то и List[Apple] можно  рассматривать как потомка List[Fruit].

  class ContravariantList[-A] // Контравариативность
  val contravariantList: ContravariantList[Apple] = new ContravariantList[Fruit]


  // Ограниченные типы
  // Мы можем ограничить типы, подходящие для нашего обобщенного класса, сказав использовать либо только подтипы, либо только супер типы.
  class Food[T <: Fruit](fruit: T) // T <: Fruit - ограничение верхнего типа
  val food = new Food(new Banana)
  // Таким образом - мы говорим, что классу Food подходят только параметры типа T, причем этот тип должен быть подтипом Fruit.
  // Так как Banana extends Fruit, то Banana нам отлично подойдет.
  class Pizza
  val moreFood = new Food(new Pizza) // В данном случае никаких связей между Pizza и Fruit не задано
  // Предварительно никакого сообщения об ошибке вы не увидите, запустить код вы не сможете, лишь словите inferred type arguments do not conform to value <local Food>'s type parameter bounds

  class Food2[T >: Fruit](fruit: T) // T >: Fruit - ограничение нижнего типа
  // Теперь в качестве типа T нам подходят только супертипы типа Fruit.
  // То есть мы может использовать только тип Fruit в качестве типа типа
}
