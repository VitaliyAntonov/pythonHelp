package lectures

object TypesPart2 {
  // Структурные типы и утиная типизация

  // Объявим тип Quacker, для которого пропишем метод quack.
  // Таким образом мы скажем, что тип Quacker подойдет всему, для чего доступен метод quack:

  type Quacker = {
    def quack(): Unit
  }

  // Также пропишем два разных класса:
  class Parrot {
    def quack(): Unit = println("I'm a quacking parrot!")
  }

  class Pigeon {
    def quack(): Unit = println("I'm a quacking pigeon")
  }

  // Оба класса имеют метод quack, а это значит, для обоих классов применим тип Quacker:

  val realParrot: Parrot = new Parrot
  val parrot: Quacker = new Parrot
  val pigeon: Quacker = new Pigeon
  parrot.quack()
  // Но как только хотя бы один из методов, определенных в типе слева,
  // не будет доступен для типа, обозначенного справа, все перестанет работать.
  // Короче если в quacker есть метода но в классе он не определен работать не будет
  // Также не будут доступны методы класса которые определены в переменную с типом Quacker и которые не находятся в нем
}

object SelfType {
  // Самоописываемый тип
  // Самоописываемый тип позволяет обозначить зависимости, используя трейты и примеси (mixins)

  // Лeгче всего self type объяснить на примере.
  // Допустим, нам необходимо, чтобы любой сотрудник компании умел программировать.
  // Данное условие можно обозначить в трейте:

  trait Skills {
    def code(): Unit
  }
  // Теперь мы можем применить это условие:

  trait Employee {
    self: Skills =>
    def work(): Unit

    def someOtherMethod(): Unit
  }
  // Тогда это пригодится нам вот здесь:

  class ProductManager extends Employee with Skills {
    override def code(): Unit = ???

    override def someOtherMethod(): Unit = ???

    override def work(): Unit = ???
  }

  // Таким образом, мы просто нигде не сможем обойтись без Skills:
  // class Developer extends Employee

  // Для какого-то конкретного сотрудника мы сразу можем прописать вот так:
  val bob = new Employee with Skills {
    override def code(): Unit = ???

    override def someOtherMethod(): Unit = ???

    override def work(): Unit = ???
  }

  // Как видите, self type очень похож на наследование, но разница есть. Если написать
  class Employee2
  class Manager extends Employee2
  // Это будет значить, что менеджер также является сотрудником. Но если написать вот так:
  trait Employee3
  trait Manager2 {self: Employee3 => }
  // Это будет означать, что менеджеру требуется сотрудник.
}

object CakePattern {
  // Обычно мы бы писали так:

  class User
  class RegisteredUser extends User
  class AnonymousUser extends User

  class AppComponent(val user: User)
  // Естественно, в качестве user для AppComponent подойдет как RegisteredUser, так и AnonymousUser.

  // В Scala представленный выше код можно переписать вот так, наслаивая функционал один за другим:
  object Cake{
    trait User{
      def info(user: String): String = user
    }

    trait AppComponent{
      self: User =>
      // смогли использовать метод info, объявленный в User
      def detailedInfo(user: String): String = "Detailed info for " + info(user)
    }

    trait Application {self: AppComponent => }

    // слой 1 - детализируем различные API
    trait RegisteredUser extends User
    trait AnonymousUser extends User

    // слой 2 - смешиваем различные компоненты
    trait Analytics extends AppComponent with AnonymousUser
    trait Profile extends AppComponent with RegisteredUser
  }
  // Преимуществом этого паттерна является то, что все зависимости проверяются во время компиляции, а не в рантайм.
}

object CyclicDependencies{
  // Циклические зависимости

  // Код вида
  //class A extends B
  //class B extends A
  // не скомпилируется по причине illegal cyclic reference involving class A

  // Однако проблема решится при использовании self type:
  class C {self: D => }
  class D {self: C => }
  // Что еще раз показывает отличие от простого наследования.
}
