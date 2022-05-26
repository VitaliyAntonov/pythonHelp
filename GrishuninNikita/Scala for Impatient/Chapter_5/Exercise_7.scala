 /**
 *  Напишите класс Person с главным конструктором, принимающим строку,
 *  которая содержит имя, пробел и фамилию, например: new Person("Fred Smith").
 *  Сделайте свойства firstName и lastName доступными только для чтения.
 *  Должен ли параметр главного конструктора объявляться как var, val или как
 *  обычный параметр? Почему?
 */
object Exercise_7 extends App {
  class Person (person: String) {
    val prsnArr = person.split(" ")
    val FirstName = prsnArr(0)
    val LastName = prsnArr(1)
  }
   val prsn = new Person("Nikita Grishunin")
   println(prsn.FirstName + " " + prsn.LastName)
}
