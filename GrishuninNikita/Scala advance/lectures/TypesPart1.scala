package lectures

object TypeMembers {
  // Члены типов
  // Пришло время посмотреть на еще один способ работы с типами - через члены типов:
  class Clazz {
    type Member
  }
  class Fruit
  class Apple extends Fruit
  class Banana extends Fruit

  // Cоздадим класс FruitCollection, внутри которого определим абстрактные члены типов.
  class FruitCollection{
    type FruitType
    type AliasApple = Apple // просто по-другому именуем уже существующий тип Apple
    type UpperBoundedFruit <: Fruit // тип с верхним ограничением
    type MultipleBoundFruit >: Apple <: Fruit // тип MultipleBoundFruit, снизу ограниченный Apple, а сверху типом Fruit
  }
  // Теперь можно объявить переменную вот с таким типом:
  val aType = new FruitCollection
  val someVal: aType.AliasApple = ???

  // Типы могут стать альтернативой обобщениям:

  trait SomeList{
    type T

    def head: T
    def tail: SomeList
    def add(value: T): SomeList
  }

  abstract class ListOfInts(value: Int) extends SomeList{
    override type T = Int
    override def head: Int = 12
    //override def tail: SomeList = new ListOfInts(2)
    //override add(value: Int): SomeList = new SomeList
  }
}

object DotType{
  // .type - ещё один способ назначить тип
  class Fruit
  class Apple extends Fruit
  class Banana extends Fruit

  class FruitCollection{
    type AliasApple = Apple
  }

  val aType = new FruitCollection
  val anApple: aType.AliasApple = new Apple

  type AppleType = anApple.type
  val anotherApple: AppleType = anApple
}

object Road{
  // Зависимость от пути
  // Любой класс может содержать в себе другой класс или объект:

  class SomeClass{
    class InnerClass
    object InnerObject
    type ClassType
  }
  // Если создать экземпляр класса
  val anInstance = new SomeClass
  // Далее вот так сделать не получится, т.к. эти типы зависимы от пути (path dependent types):
  // val innerInstance = new InnerClass // так не получится
  // val innerInstance = new SomeClass.InnerClass // так тоже не выйдет

  // Зато все будет ок для вот такого:
  val innerInstance = new anInstance.InnerClass
}

object SuperType{
  // Супер-тип

  class SomeClass{
    class InnerClass
    def print(value: InnerClass): Unit = println(value)
  }

  val anInstance = new SomeClass
  val innerInstance = new anInstance.InnerClass

  val anotherInstance = new SomeClass
  val anotherInnerInstance = new anotherInstance.InnerClass

  // Возможно, вы уже догадались, что типы у innerInstance и anotherInnerInstance - разные, ведь первая была создана через anInstance, а вторая - через anotherInstance.
  // Поэтому ничего удивительного в получаемых ниже результатах нет:

  anInstance.print(innerInstance) // всё ок
  // anInstance.print(anotherInnerInstahce) // не получится

  // Чтобы обойти эту проблему и создать универсальный метод принт, на вход принту надо подавать переменную подходящего супер-типа.
  // В нашем случае это будет SomeClass#InnerClass:

  object SuperTypeValue {
    class SomeClass{
      class InnerClass
      def print(value: InnerClass): Unit = println(value)
      def superPrint(value: SomeClass#InnerClass): Unit = println(value)
    }

    val anInstance = new SomeClass
    val anotherInstance = new SomeClass

    val innerInstance = new anInstance.InnerClass
    val anotherInnerInstance = new anotherInstance.InnerClass

    anInstance.superPrint(innerInstance)
    anInstance.superPrint(anotherInnerInstance)
  }
}
