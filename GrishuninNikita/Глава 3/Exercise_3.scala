/**
 * Повторите предыдущее упражнение, но создайте новый массив
 * с переставленными элементами. Используйте for/yield.
 */
object Exercise_3 extends App {
  val arr =  Array(1, 2, 3, 4, 5)
  println(arr.mkString(", "))
  val res = for(i <- 0 until arr.length) yield
    if(i % 2 == 0 && i < arr.length - 1) arr(i+1)
    else if (i % 2 != 0) arr(i-1)
    else arr(i)
  println(res.mkString(", "))
}
