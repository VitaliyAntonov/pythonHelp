package lectures

object Sugar {
  // Если значение аргумента, передаваемого в функцию с одним аргументом, следует предварительно вычислить.
  // И больше это вычисленное значение нигде в коде не потребуется, то имеет смысл передавать этот аргумент в фигурных скобках вместо круглых.
  // Тогда в фигурных скобках (фигурные скобки означают, что используется блок кода) можно прописать все необходимые вычисления:
  def methodWithSingleArg(arg: Int): String = s"Получено число $arg"

  val someNumb = methodWithSingleArg {
    val someString = "в этом блоке кода производятся сложные вычисления"
    someString.length
  }
  println(someNumb) // Получено число 49

  // Трейты, классы и лямбда-функции

  // Если в трейте описан всего один метод, то такой трейт легко можно переписать в виде лямбда-функции.
  // Например, если написать вот такой код:
  trait SomeTrait {
    def doSomething(s: String): String
  }

  val anInstance: SomeTrait = (s: String) => s"I'm doing $s"

  // Аналогичные действия можно проделать для класса, который содержит в себе только один неимплементированный метод
  abstract class SomeAbstractClass {
    def someMethod: String = "метод имплементирован"

    def unimplementMethod(s: String): Unit
  }

  val anInstanceSome = new SomeAbstractClass {
    override def unimplementMethod(s: String): Unit = println("теперь понятно что делать")
  }
  val anAbstractInstance: SomeAbstractClass = (s: String) => println("теперь понятно что делать")

  // Инфиксная нотация применима и к обобщениям
  class SomeClass[A, B](a: A, b: B) {
    def getAB: String = s"$a $b"
  }

  val someClass: String SomeClass String = new SomeClass[String, String]("StrA", "StrB") // Указание типов в инфиксной нотации
  val sameSomeClass: SomeClass[String, String] = new SomeClass[String, String]("StrA", "StrB") // Обычный способ указания типов

  // Работа с классами: изменение значений
  // Часто можно встретить код, где методы для получения(геттер) и изменения значения(сеттер) прописывают таким образом,
  // что их имена практически совпадают, разве что на конце для сеттера дописывается _=
  // Это повзоляет сократить код при обращении к методу

  class SampleClass[A](var someVal: A) {
    def sample: A = someVal // Получение значения

    def sample_=(newVal: A): Unit = { // Изменение значения
      someVal = newVal
    }
  }

  val sampleInstance = new SampleClass[Int](5)
  println(sampleInstance.sample, sampleInstance.sample = 2)
}
