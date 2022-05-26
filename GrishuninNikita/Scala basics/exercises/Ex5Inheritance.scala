package exercises

object Ex5Inheritance extends App {
  class Button(label: String) {
    def click(): String = "button" + " " + "-" + s"$label" + "-" + " " + "has been clicked"
    def this() = this("test")
  }
  class RoundedButton(label: String) extends Button(label){
    override def click(): String = "rounded" + " " + s"${super.click()}"
  }
}
