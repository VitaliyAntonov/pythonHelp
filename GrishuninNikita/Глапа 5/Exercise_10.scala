/**
 *   Взгляните на следующее определение класса:
 *   class Employee(val name: String, var salary: Double) {
 *   def this() { this("John Q. Public", 0.0) }
 *   }
 *   Перепишите его так, чтобы он содержал явные определения
 *   полей и имел главный конструктор по умолчанию.
 */
object Exercise_10 extends App {
  class Employee(name: String, var salary: Double){
    val nm = name
    var salr = salary
  }
  val empl = new Employee("Nikita", 222000)
}
