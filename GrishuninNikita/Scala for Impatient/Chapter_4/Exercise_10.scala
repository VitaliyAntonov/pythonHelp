/**
 * Что произойдет, если попытаться упаковать две строки, такие
 * как "Hello".zip("World")?
 * Буквы слов обьединятся по индексу.
 */

object Exercise_10 extends App{
  val symbols = "Hello".zip("World")
  println(symbols.mkString(", "))
}
