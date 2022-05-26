/**
 * Существуют десятки руководств, описывающих особенности использования трейтов в языке Scala
 * на простеньких примерах с лающими собаками или философствующими лягушками.
 * Знакомство с иерархиями, высосанными из пальца, – весьма утомительное и малополезное занятие,
 * а вот создание собственной иерархии действует весьма просветляюще.
 * Создайте собственный простой пример иерархии трейтов, демонстрирующий многоуровневые трейты,
 * конкретные и абстрактные методы, а также конкретные и абстрактные поля.
 */
object Exercise_8 extends App {
  trait arithmetic{
    def multiple(x:Double, y: Double): Double //абстрактные методы
    def division(x:Double, y: Double): Double
  }
  trait multiple extends arithmetic{
    override def multiple(x: Double, y: Double): Double = x * y //Переопределение абстрактных методов
  }
  trait division extends arithmetic{
    override def division(x: Double, y: Double): Double = x / y
  }
  trait actions extends multiple with division { // Многоуровненый трейт
    def sumdiv(x: Double, y: Double): Double = division(x, y) + (x + y) // Конкретные методы
    def submult(x: Double, y: Double): Double = multiple(x, y) - (x - y)
  }
  class numbers(val x: Double, val y: Double) extends actions{
    println(multiple(x, y), division(x, y), sumdiv(x, y), submult(x, y))
  }
  val num = new numbers(2, 3)
}
