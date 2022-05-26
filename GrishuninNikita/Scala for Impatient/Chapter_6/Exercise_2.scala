/**
 * Предыдущую задачу трудно назвать объектно-ориентированной.
 * Реализуйте общий суперкласс UnitConversion и определите
 * объекты InchesToCentimeters, GallonsToLiters и MilesToKilometers,
 * наследующие его
 */
object Exercise_2 extends App{
class UnitConversation {
  def convert : Double = 2
}

object inchesToCentimeters extends UnitConversation {
  def inchToCm : Unit = {println(convert * 2.54)}
}
object gallonsToLiters extends UnitConversation {
  def gsToLtr : Unit ={ println (convert * 3.785)}
}
object milesToKilometers extends UnitConversation {
  def milToKm: Unit = {println(convert * 1.287)}
}
  inchesToCentimeters.inchToCm
  milesToKilometers.milToKm
  gallonsToLiters.gsToLtr
}
