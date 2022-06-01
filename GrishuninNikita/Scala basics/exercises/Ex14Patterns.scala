package exercises

object Ex14Patterns extends App{
  def guard(data: Any, maxLength: Int): String ={
    data match {
      case list: List[Any] if list.length <= maxLength => "Задан список List допустимой длины"
      case list: List[Any] if list.length > maxLength => "Длина списка больше максимально допустимого значения"
      case x: String if x.length <= maxLength => "Длина строки не превышает максимально допустимого значения"
      case x: String if x.length > maxLength => "Получена строка недопустимой длины"
      case _ => "Что это? Это не строка и не список"
    }
  }
}
