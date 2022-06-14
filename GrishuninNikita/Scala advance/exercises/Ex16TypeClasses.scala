package exercises

object Ex16TypeClasses extends App {
  case class JsonObject[T](value: Map[String, T])
  case class JsonArray[T](value: List[T])
  case class JsonString[T](value: T)
  case class JsonInteger[T](value: T)

  def stringify[T](x: JsonObject[T]) ={
    s"${JsonObject}"
  }

  val data = JsonObject(Map(
    "name" -> JsonString("Bob"),
    "items" -> JsonArray(
      List(
        JsonInteger(1),
        JsonString("Stuff to buy"))
    )
  ))

}
