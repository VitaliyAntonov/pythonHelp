package lectures.week3fp

object Options extends App{
  // Опции - это способ защиты от NullPointerException
  // Дела обстоят так, что не следует вручную делать проверки на Null - доверьте это дело Option, поместив в него переменную, которую подозреваете в отсутствии значения
  def unsafeMethod(): String = null
  def safeMethod(): String = "There is a String"
  val unsafeRes = Option(unsafeMethod())
  val safeRes = Option(safeMethod())
  println(unsafeRes)
  println(safeRes)

  // Option и orElse
  // Когда есть необходимость протестировать несколько методов одновременно с помощью Option, сделать код лаконичнее поможет конструкция orElse
  def maybeSafeMethod(): Option[String] = Some("There is no harm")
  val chainedResult = Option(unsafeMethod()).orElse(Option(maybeSafeMethod()))
  println(chainedResult) // Some(There is no harm)
}
