/**
 * Напишите метод sum с переменным числом целочисленных аргументов,
 * возвращающий сумму своих аргументов. Вызовите его из Java.
 */
object Exercise_4 extends App{
  import scala.annotation.varargs
  @varargs def sum(x: Int*) = x.sum
  println(sum(5, 4, 3, 2, 1))
}

