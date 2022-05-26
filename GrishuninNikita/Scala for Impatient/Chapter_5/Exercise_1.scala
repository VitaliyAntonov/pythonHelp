/**
 * Усовершенствуйте класс Counter в разделе 5.1 «Простые классы
 * и методы без параметров», чтобы значение счетчика не превращалось
 * в отрицательное число по достижении Int.MaxValue.
 */
object Exercise_1 extends App {
  class Counter {
    private var value: Int = 0
    def increment() {
      if(value < Int.MaxValue)value += 1 // Если value меньше Int.MaxValue то мы прибавляем к value 1
      else if (value == Int.MaxValue) value = 0 //Если значение счётчика становится Int.MaxValue, то он обнуляется
    }
    def current() = value
  }
  val MyCounter = new Counter()
  for(i <-0 to Int.MaxValue){
    MyCounter.increment()
  }
  MyCounter.increment()
  println(MyCounter.current())
}
