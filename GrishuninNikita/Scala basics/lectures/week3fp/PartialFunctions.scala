package lectures.week3fp

object PartialFunctions extends App {
  // Частичные функции
  // Часто бывает так, что требуется ограничить значения, которые можно подавать на вход функции. Конечно, можно выкрутиться через шаблоны. Так, например, мы допускаем только значения mon, fri, sun
  val whatToDo = (d: String) => d match {
    case "mon" => "Work!"
    case "fri" => "Party Time"
    case "sun" => "Relax a little"
  }
  // Однако есть и другое решение, которое основано на применении PartialFunction.
  val aPartialFunction: PartialFunction[String, String] = {
    case "mon" => "Work!"
    case "fri" => "Party Time"
    case "sun" => "Relax a little"
  }
  println(aPartialFunction("sun")) // Relax a little
  println(aPartialFunction("sat")) // MatchError

  // Для недопустимого значения получаем MatchError - намек, что частичные функции основаны на совпадении шаблонов.
  // Последний из указываемых в квадратных скобках типов обозначает тип возвращаемого значения.

  // Можно заранее узнать, допустимо ли использовать аргумент в функции или нет. В этом нам поможет isDefined:
  println(aPartialFunction.isDefinedAt("tue")) // false

  // Частичные функции и orElse
  // Объединить несколько функций в цепь нам поможет orElse
  val pfChain: PartialFunction[String, String] = aPartialFunction.orElse[String, String]{
    case "sat" => "It's just Saturday"
  } // Если aPartialFunction содержит нужный нам case, возвращаем его значение, иначе переключаемся на следуюущую функцию
  println(pfChain("mon")) // Work!
  println(pfChain("sat")) // It's just Saturday

  // Лифтинг
  // Лифтинг позволяет поднять частичную функцию на следующий уровень.
  // После lift - функция будет возвращать значения типа Option (т.е. решается проблема MatchError).
  val lifted = aPartialFunction.lift // теперь на выходе имеем тип Option[String]
  println(lifted("fri")) // Some(Party Time)
  println(lifted("thu")) // None

}
