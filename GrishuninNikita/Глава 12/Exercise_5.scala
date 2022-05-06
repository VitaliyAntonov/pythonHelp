/**
 * Напишите функцию largest(fun: (Int) => Int, inputs: Seq[Int]),
 * возвращающую наибольшее значение функции внутри заданной последовательности.
 * Например, вызов largest(x => 10 * x – x * x, 1 to 10) должен вернуть 25.
 * Не используйте цикл или рекурсию.
 */

object Exercise_5 extends App{
  def largest(fun: (Int) => Int, inputs: Seq[Int]) = inputs.map(fun).reduceLeft(math.max) // Объединение первого и второго упражнения
  val b = largest(x => 10 * x - x * x, 1 to 10)
  println(b)
}
