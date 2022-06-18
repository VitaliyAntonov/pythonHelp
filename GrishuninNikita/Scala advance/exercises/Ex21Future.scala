package exercises

import scala.util.Random

object Ex21Future extends App {
  import scala.concurrent._
  import ExecutionContext.Implicits.global

  def retry[A](action: () => Future[A], condition: A => Boolean): Unit = {

  }
  val random = new Random()
  val aString = List("a", "ab", "abc", "abcd")

  val action = () => Future{
    val idx = random.nextInt(4)
    aString(idx)
  }

  // retry(action, (s: String) =>  s.length > 3).foreach(result => println(result))
}
