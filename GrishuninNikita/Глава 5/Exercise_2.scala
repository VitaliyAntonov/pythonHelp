/**
 *  Напишите класс BankAccount с методами deposit и withdraw
 *  и свойством balance, доступным только для чтения.
 */
object Exercise_2 extends App {
  class BankAccount {
    private var balance = 0
    def deposit(value:Int): Unit ={
      balance += value
    }
    def withdraw(value:Int): Unit = {
      balance -= value
    }
    def current = balance
  }
  val BA = new BankAccount
  BA.deposit(100)
  println(BA.current)
  BA.withdraw(95)
  println(BA.current)
}
