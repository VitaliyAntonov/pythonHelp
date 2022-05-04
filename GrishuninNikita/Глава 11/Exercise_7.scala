/**
 * Реализуйте класс BitSequence для хранения 64-битных последовательностей в виде значений типа Long.
 * Реализуйте операторы apply и update для получения и установки отдельных битов.
 */
object Exercise_7 extends App {
  class BitSequence(var bits: Long = 0) {
    def apply(index: Byte): Boolean = (bits & (1 << index)) > 0
    def update(index: Byte, value: Boolean) {
      if (value)
        bits |= (1 << index)
      else
        bits &= ~(1 << index)
    }
  }
  val bs = new BitSequence(255) // 11111111
  println(bs(0), bs(1), bs(2), bs(3), bs(4), bs(5), bs(6), bs(7)) // все true
  bs.update(0, false)// измение первого индекса на 0, 244 011111111
  println(bs(0), bs.bits)
}
