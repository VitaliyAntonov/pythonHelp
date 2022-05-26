package exercises

import scala.annotation.tailrec

object Ex1Recursion extends App {
  def powerOfTwo(power: Int): BigInt = {
    @tailrec
    def loop(power: Int, two: BigInt = 2): BigInt = {
      if(power == 1) two
      else if (power <= 0) 1
      else loop(power - 1, two * 2)
    }
    loop(power)
  }
  println(powerOfTwo(32))
}
