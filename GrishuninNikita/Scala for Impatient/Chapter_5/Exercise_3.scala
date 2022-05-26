/**
 *  Напишите класс Time со свойствами hours и minutes, доступными только для чтения,
 *  и методом before(other: Time): Boolean, который проверяет, предшествует ли время this
 *  времени other. Объект Time должен конструироваться как new Time(hrs, min),
 *  где hrs – время в 24-часовом формате.
*/
object Exercise_3 extends App {
  class Time (hrs:Int, min: Int){
    private var hours = hrs
    private var minutes = min
    def before(other: Time): Boolean = {
    hours > other.hours || (hours == other.hours && minutes > other.minutes) //Возвращет true или false в зависимости от того больше ли time или other.time
    }
  }
  val Time = new Time(22,35)
  val Time1 = new Time(20,19)
  println(Time.before(Time1))// Time > Time1 => True
}
