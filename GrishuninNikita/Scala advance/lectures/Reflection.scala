package lectures

object Reflection {
  // Немного заглянем в область метапрограммирования, когда программа начинает манипулировать другими программами.
  // Вполне может возникнуть необходимость обратиться к классу динамически - во время исполнения программы, то есть
  // без прописывания имени этоо класса в коде заранее. Осуществить это помогут отражения.

  // Для использования отражений нам потребуется выполнить импорт:
  import scala.reflect.runtime.universe
  // Вполне возможно сократить имя подключаемой библиотеки для упрощения дальнейшего доступа:
  import scala.reflect.runtime.{universe => ru}

  // Далее объявим зеркало:
  val mir = ru.runtimeMirror(getClass.getClassLoader)
  // getClassLoader позволяет загружать классы непосредственно в рантайм.

  // Посредством зеркала мы можем создавать объекты класса:
  case class Course(title: String) {
    def info(): Unit = println(s"This is $title course")
  }
  val courseClass = mir.staticClass("advanced.Reflections.Course")
  // Тип ClassSymbol(ключевое слово здесь Symbol) говорит о том, что мы получили что-то в ходе описания класса или же
  // информацию о том, какие возможности дает класс.

  // Воспользовавшись ClassSymbol, можно создать ClassMirror, которое получает доступ ко всем методам класса:

  val classMirror = mir.reflectClass(courseClass) // Тип ClassMirror

  // Поработаем с конструктором класса:
  val constructor = courseClass.primaryConstructor.asMethod
  // constructor будет иметь тип MethodSymbol, т.е. это всего лишь описание.
  // А раз так, то нам потребуется зеркало:
  val constructorMirror = classMirror.reflectConstructor(constructor)
  // Наконец, конструктор стал доступен для вызова:
  val instance = constructorMirror.apply("Scala")
}

object reflection {
  // Оперирование уже имеющимися объектами
  // Допустим, дан следующий код:
  import scala.reflect.runtime.{universe => ru}

  case class Course(title: String) {
    def info(): Unit = println(s"This is $title course")
    def update(): Unit = println(s"Course content was updated")
  }
  val course = Course("Scala")

  // Мы не знаем заранее, какой из методов нам потребуется вызвать.
  // Имя этого метода станет нам известно уже после запуска.
  // Пусть этим методом будет info:

  val methodName = "info"

  // Тогда для динамического вызова метода потребуется прописать следующий код:
  val mir = ru.runtimeMirror(getClass.getClassLoader)
  val instanceMirror = mir.reflect(course)
  val methodSymbol = ru.typeOf[Course].decl(ru.TermName(methodName)).asMethod
  val method = instanceMirror.reflectMethod(methodSymbol)
  // И тогда метод станет доступен для вызова:
  method.apply() // This is Scala course
}

object TypeErasure {
  // Стирание типа
  // Типы параметров, задействованные в программе, проверяются на этапе компиляции,
  // которая прерывается при наличии каких-либо проблем.
  // Соответсветенно, далее в информации о типах нет необходимости, и они стираются.
  // Т.е в рантайм типы не различаются
  val strings = List("a", "b", "c")
  val foundPattern = strings match {
    case listOfNumbers: List[Int] => "list of numbers"
    case listOfStrings: List[String] => "list of strings"
  }
  println(foundPattern) // list of numbers

  // Собственно, проблемы будут возникать и вот в этом случае:
  // def processList(list: List[Int]): String = "list of ints"
  // def processList(list: List[String]): String = "list of strings"

  // Для нас это выглядит, как код с перегруженными методами, но не для компилятора.
  // Обойти подобные ситуации помогут тэги (type tags).
}

object TypeTags extends App {
  import scala.reflect.runtime.{universe => ru}
  import ru._

  // Создать тэг вручную можно следующим образом:
  class Course

  val aTag = typeTag[Course]
  println(aTag.tpe)

  // Хотя и дозволяется конструировать тэги вручную, на практике они передаются в виде имплиситных параметров.
  // Это будет продемонстрировано далее. У нас есть класс, требующий два дженерик параметра.
  // Попробуем получить заданные типы динамически:

  def getTypeArguments[T](value: T)(implicit typeTag: TypeTag[T]) = typeTag.tpe match {
    case TypeRef(_, _, typeArguments) => typeArguments
    case _ => List()
  }
  class MyClass[A, B]

  val myClass = new MyClass[Int, String]
  val typeArgs = getTypeArguments(myClass)
  println(typeArgs) // List(Int, String)

  // Такой доступ к типам дает возможность производить требуемые проверки.
  // Протестируем, является ли A подтипом B:

  def isSubtype[A, B](implicit aTagA: TypeTag[A], aTagB: TypeTag[B]): Boolean = {
    aTagA.tpe <:< aTagB.tpe
  }

  class Fruit
  class Apple extends Fruit
  println(isSubtype[Apple, Fruit]) // true

  // Проверка работает, т.к. компилятор успевает сконструировать тэги aTagA, aTagB во время компиляции - до того, как происходит стирание типов.

}
