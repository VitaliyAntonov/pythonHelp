package exercises

object Ex13TypeClasses extends App {
  trait Custom[T]{
    def compare(orderA: T, orderB: T): Boolean
  }

  case class Customer(id: String, name: String)
  case class Order(orderId: String, customer: Customer, date: String)

  object CustomerCheck extends Custom[Order]{
    def compare(orderA: Order, orderB: Order): Boolean = if(orderA.customer.id.toInt > orderB.customer.id.toInt) true else false
  }
  object DateAndCustomerCheck extends Custom[Order]{
    def compare(orderA: Order, orderB: Order): Boolean = if(orderA.customer.id.toInt > orderB.customer.id.toInt & orderA.date.toInt > orderB.date.toInt) true else false
  }
}
