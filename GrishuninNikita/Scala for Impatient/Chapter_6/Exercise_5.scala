/**
 * Напишите приложение на языке Scala, используя трейт App,
 * которое выводит аргументы командной строки в обратном
 * порядке, разделяя их пробелами. Например, команда scala
 * Reverse Hello World должна вывести World Hello
 */

object Exercise_5 extends App {
  val str = "Hello World"
  str.reverse.map(a => print(a + " "))
}
