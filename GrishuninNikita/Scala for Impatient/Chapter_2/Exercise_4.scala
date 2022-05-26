/**
 * Напишите на языке Scala цикл, эквивалентный циклу for на
 * языке Java: for (int i = 10; i >= 0; i--) System.out.println(i);
 */
object Exercise_4 extends App {
  for (i <- 10 to 0 by -1) {
    println(i)
  }
}
