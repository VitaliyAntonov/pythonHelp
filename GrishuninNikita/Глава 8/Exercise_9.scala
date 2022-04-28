/**
 * В классе Creature из раздела 8.10 «Порядок создания и опережающие определения» замените val range на def.
 * Что произойдет, когда вы также будете использовать def в подклассе Ant?
 * Будет иницииализироваться массив размерностью 2
 * Что произойдет, если в подклассе использовать val?
 * Если в подклассе использовать val будет иницииализироваться массив размерностью 0
 *
 */
object Exercise_9 extends App{
  class Creature {
    def range: Int = 10
    val env: Array[Int] = new Array[Int](range)
  }
  class Ant extends Creature {
    override def range = 2
  }
  val cr = new Creature
  val ant = new Ant
  println(cr.env.mkString(", "))
  println(ant.env.mkString(", "))
}