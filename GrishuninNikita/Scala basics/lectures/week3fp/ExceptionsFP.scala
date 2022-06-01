package lectures.week3fp

object ExceptionsFP extends App {
  // Try
  // Чтобы исползовать Try необходимо его импортировать
  import scala.util.{Try, Failure, Success}
  // Далее особых сложностей в его использовании нет. Просто пишем Try, а затем в круглых скобках указываем метод, который было бы желательно проверить
  def unsafeMethod(): String = throw new RuntimeException("Sorry, not your day")
  val potentialFailure = Try(unsafeMethod())
  println(potentialFailure)
  // В качестве альтернативы - можно писать Try, затем через пробел открывать фигурные скобки, в которых прописывать код для тестирования.
  val anotherPotentialFailure = Try {
    // код, содержащий исключения
  }
  // Еще одна удобная штука - это то, что мы можем заранее проверить, содержит ли метод исключения, получив в ответ true или false
  println(potentialFailure.isSuccess) // false
  // Try и orElse
  // Когда есть необходимость протестировать несколько методов одновременно с помощью Try, сделать ваш код лаконичнее поможет конструкция orElse.
  def myMethod(): String = "My method is valid"
  val executeWithTry = Try(unsafeMethod()).orElse(Try(myMethod()))
  println(executeWithTry) // Success(My method is valid)
  // Еще одним вариантом будет обернуть в Try результат работы вашего метода.
  def methodWhichFails(): Try[String] = Failure(new RuntimeException("Ooops..."))
  def methodWhichSucceeds(): Try[String] = Success("Everything is OK")
  val tryMethods = methodWhichFails() orElse methodWhichSucceeds()
  println(tryMethods) // Success(Everything is OK)
}
