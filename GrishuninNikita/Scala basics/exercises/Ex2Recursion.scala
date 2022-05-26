package exercises

import scala.annotation.tailrec

object Ex2Recursion extends App {
  def upn(x: Int, y: Int, n: Int): String = {
    @tailrec
    def loop(x: Int, y: Int, n: Int): Int = {
      if (n == 0) x
      else loop(x + y, y, n - 1)
    }

    loop(x, y, n).toString
  }

  def prnt(number: String): Unit = {
    @tailrec
    def loop(x: String, n: Int = number.length): String = {
      if (n <= 1) x
      else loop(s"$number $x", n - 1)
    }
    println(loop(number) + " is the result")
  }
  prnt(upn(10 , 10 , 50))
}
