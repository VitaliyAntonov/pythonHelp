/**
 * Определите класс SavingsAccount, наследующий класс BankAccount из предыдущего упражнения,
 * который начисляет проценты каждый месяц (вызовом метода earnMonthlyInterest)
 * и позволяет бесплатно выполнять три операции зачисления или списания каждый месяц.
 * Метод earnMonthlyInterest должен сбрасывать счетчик транзакций.
 */
object Exercise_2 extends App{
  class BankAccount(initialBalance: Double) {
    var balance = initialBalance
    def currentBalance = balance
    def deposit(amount: Double) = { balance += amount}
    def withdraw(amount: Double) = { balance -= amount}
  }
  class SavingAccount(initialBalance: Double) extends BankAccount(initialBalance){
    var i = 0
    override def deposit(amount: Double) = {
      if(i > 2) balance += amount - 1
      else balance += amount; i += 1
    }
    override def withdraw(amount: Double) = {
      if(i > 2) balance -= amount - 1
      else balance -= amount; i += 1
    }
    def earnMonthlyInterest: Unit ={
      val percent = 0.2
      balance += balance * percent
      i = 0
    }
  }
  val sa = new SavingAccount(2000)
  sa.earnMonthlyInterest
  sa.deposit(1)
  sa.deposit(1)
  sa.deposit(1)
  sa.deposit(1)
  println(sa.currentBalance)
}
