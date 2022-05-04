/**
 * Реализуйте класс ASCIIArt, объекты которого содержат фигуры.
 * Добавьте операторы для объединения двух фигур ASCIIArt по горизонтали или по вертикали.
 * Выберите операторы с соответствующими приоритетами
 */
object Art1{
  val a = " /\\_/\\\n( ' ' )\n(  -  )\n | | |\n(__|__)"
  val b = " /\\_/\\    ----- \n( ' ' ) / Hello \\\n(  -  ) < Scala |\n | | |  \\ Coder /\n(__|__)   -----"
}
object Exercise_6 extends App {
  class Art(val art: String){
    private val strings = art.split("\r\n")
    def +|(other: Art): Art = new Art (art + "\n" + other.art)
    def draw = print(strings.mkString("\r\n"))
  }
  val r = new Art(Art1.a) +| new Art(Art1.b)
  r.draw

}
