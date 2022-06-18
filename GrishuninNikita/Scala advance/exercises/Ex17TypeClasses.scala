package exercises

object Ex17TypeClasses extends App {
  sealed trait Json
  case class JsonObject(value: Map[String, Any]) extends Json
  case class JsonArray(value: List[Any]) extends Json
  case class JsonString(value: String) extends Json
  case class JsonInteger(value: Int) extends Json

  trait JsonWriter[A]{
    def write(value: A): Json
  }

  implicit val stringWriter: JsonWriter[String] =
    new JsonWriter[String]{
      def write(value: String): Json = JsonString(value)
    }

  def stringify(x: JsonObject) ={
  }

  val data = JsonObject(Map(
    "name" -> JsonString("Bob"),
    "items" -> JsonArray(
      List(
        JsonInteger(1),
        JsonString("Stuff to buy"))
    )
  ))
  println(data.value.get("name"))
}
