/**
 * Напишите объект Conversions с методами inchesToCentimeters,
 * gallonsToLiters и milesToKilometers.
 */

import Conversions._

object Conversions {
  def inchesToCentimeters(n: Double): Double ={n * 2.54}
  def gallonsToLiters(n: Double): Double ={ n * 3.785}
  def milesToKilometers(n: Double): Double = {n * 1.287}
}

object Exercise_1 extends App {
  val a = 5.0
  println(inchesToCentimeters(a), gallonsToLiters(a), milesToKilometers(a))
}
