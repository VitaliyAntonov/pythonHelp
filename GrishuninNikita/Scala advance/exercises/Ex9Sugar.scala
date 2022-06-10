package exercises

import scala.math.BigDecimal.int2bigDecimal

object Ex9Sugar extends App {
  val capacity = 34
  val power = capacity
  val powerOfTwo = Math.pow(2, power).toLong
  println(powerOfTwo)
}
