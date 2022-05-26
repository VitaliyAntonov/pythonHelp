import scala.collection.mutable.ArrayBuffer

/**
 * Реализуйте метод equals в классе Member, вложенном в класс Network, в разделе 19.2 «Проекции типов».
 * Два члена сообщества могут быть признаны равными, если только они принадлежат одному сообществу.
 */
object Exercise_4 extends App{
  class Network {
    class Member(val name: String) {
      val contacts = new ArrayBuffer[Network#Member]

      override def equals(obj: Any): Boolean = obj match{
        case that: Member => this.name == that.name
        case _ => false
      }
    }
    private val members = new ArrayBuffer[Member]
    def join(name: String) = {
      val m = new Member(name)
      members += m
      m
    }
  }
  val chatter = new Network
  val myFace = new Network
  val fred = chatter.join("Fred")
  val wilma = myFace.join("Wilma")
  println( fred.equals(wilma))
}
