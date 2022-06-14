package exercises

object Ex14TypeClasses extends App {
  val greeting = "My name is Bob and I'm a Developer. And I have 3 years of experience."
  implicit class Greeting(text: String){
    def name: String = text.split(" ").toList.tail.tail.tail.head
    def occupation: String = text.split(" ").toList.tail.tail.tail.tail.tail.tail.tail.head.replaceAll("\\.", "")
    def level: String = text.split(" ").toList.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head.toInt match{
      case 1 => "junior"
      case 2 => "middle"
      case 3 => "middle"
      case 4 => "middle"
      case _ => "senior"
    }
    def isMiddle: Boolean = if(text == "middle") true else false
  }
  println(greeting.name)
  println(greeting.occupation)
  println(greeting.level.isMiddle)
}
