/**
 * Определите класс CheckingAccount, наследующий класс BankAccount,
 * который взимает $1 комиссионных за каждую операцию пополнения или списания.
 */
object Exercise_1 extends App{
  class BankAccount(initialBalance: Double) {
    var balance = initialBalance
    def currentBalance = balance
    def deposit(amount: Double) = { balance += amount; balance }
    def withdraw(amount: Double) = { balance -= amount; balance }
  }
  class CheckingAccount(initialBalance: Double) extends BankAccount(initialBalance){
    override def deposit(amount: Double) = {balance += amount - 1; balance}
    override def withdraw(amount: Double) = { balance -= amount - 1; balance}
  }
  val ca = new CheckingAccount(2000)
  ca.deposit(200)
  println(ca.currentBalance)
}
