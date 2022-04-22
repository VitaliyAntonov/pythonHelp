/**
 *  Создайте класс Student со свойствами в формате JavaBeans name (типа String) и id (типа Long),
 *  доступными для чтения/записи. Какие методы будут сгенерированы?
 *  (Используйте javap для проверки.) Сможете ли вы вызывать методы доступа
 *  в формате JavaBeans из программного кода на языке Scala?
*/
import scala.beans.BeanProperty
import scala.reflect._
object Exercise_5 extends App {
  class Student (name : String, id: Long){
    @BeanProperty var stdName = name
    @BeanProperty var stdId = id
  }
  val std = new Student("Nikita", 2885)
  println(std.stdName, std.stdId)
  std.setStdId(25)
  std.setStdName("Ivan")
  println(std.stdName, std.stdId)
  val ID = std.getStdId
  val Name = std.getStdName
  val Name2 = "Annie"
  println(Name, ID)
  std.stdName_=(Name2:String) : Unit
  std.stdId_=(20:Long) : Unit
  println(std.stdName, std.stdId)
}
