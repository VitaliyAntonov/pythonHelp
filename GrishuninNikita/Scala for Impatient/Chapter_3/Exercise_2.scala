/**
 * Напишите цикл, меняющий местами смежные элементы в массиве целых чисел.
 * Например, Array(1, 2, 3, 4, 5) должен стать Array(2, 1, 4, 3, 5).
 */
object Exercise_2 extends App {
  val arr =  Array(1, 2, 3, 4, 5)
  println(arr.mkString(", "))
  for(i <- 0 until arr.length){
    if(i!= 0 && i % 2 !=0){
      val nxt = arr(i)
      arr(i) = arr(i - 1)
      arr(i-1) = nxt
    }
  }
  println(arr.mkString(", "))
}
