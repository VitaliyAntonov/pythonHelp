/**
 * еализуйте абстракцию управления потоком выполнения unless,
 * действующую подобно if, но с инвертированным толкованием логического условия.
 */

object Exercise_10 extends App{
  def unless(condition: => Boolean)(block: => Unit): Unit = if (!condition) block
  val a = false
  var b = false
  unless(a){
    b = true
  }
  println(b)
}
