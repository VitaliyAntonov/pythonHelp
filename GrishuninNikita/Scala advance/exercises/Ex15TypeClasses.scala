package exercises

object Ex15TypeClasses extends App {
  trait Discount {
    def apply(): String
  }
  def discount(discount: Discount) = discount()
  implicit class discountInt(x: Int) extends Discount{
    override def apply(): String = s"$x % discount"
  }
  implicit class discountString(x: String) extends Discount{
    override def apply(): String = s"coupon applied"
  }
  val aDiscount = "5"
  println(discount("SLEVA"))
}
