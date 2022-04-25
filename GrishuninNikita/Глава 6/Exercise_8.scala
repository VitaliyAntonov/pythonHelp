/**
 * Напишите перечисление, описывающее восемь углов цветового куба RGB.
 * В качестве числовых идентификаторов должны использоваться значения цвета (например, 0xff0000 – для Red).
 */

object Exercise_8 extends App {
  object RGB extends Enumeration{
    type RGB = Value
    val red = Value(0xff0000)
    val yellow = Value(0xffff00)
    val green = Value(0x00ff00)
    val black = Value(0x000000)
    val cyan = Value(0x00ffff)
    val blue = Value(0x0000ff)
    val white = Value(0xffffff)
    val magenta = Value(0xff00ff)
  }
  println(RGB.red.toString)
}
