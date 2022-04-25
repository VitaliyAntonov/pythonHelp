/**
 *  Перепишите класс Time из предыдущего упражнения, чтобы
 *  внутри время было представлено количеством минут, прошедших с начала суток
 *  (между 0 и 24×60 – 1). Общедоступный интерфейс при этом не должен измениться.
 *  То есть эти изменения не должны оказывать влияния на клиентский код.
*/
object Exercise_4 extends App {
  class Time (hrs:Int, min: Int){
    private var hours = hrs
    private var minutes = min
    minutes = hours * 60 - 1 + minutes
    def before(other: Time): Boolean = {
      minutes > other.minutes //Возвращет true или false в зависимости от того больше ли time или other.time
    }
  }
  val Time = new Time(22,35)
  val Time1 = new Time(22,19)
  println(Time.before(Time1))// Time > Time1 => True
}
