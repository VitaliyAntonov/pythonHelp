/**
 * Напишите класс, демонстрирующий все возможные способы размещения аннотаций.
 * В качестве образцовой используйте аннотацию @deprecated.
 */
object Exercise_2 extends App{
  @deprecated (message = "Use person(n: String, a:Int) instead", since = "1")
  class person(n: String, a:Int){
    @deprecated(message = "Something message")
    val age = a
    @deprecated(message = "Something message")
    val name = n
  }
  val a = new person("Nikita", 19)
  println(a.age, a.name)
}

