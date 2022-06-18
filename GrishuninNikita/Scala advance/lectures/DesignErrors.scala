package lectures

object DesignErrors extends App{
  // Конкуренция или состояние гонки
  // В ситуации конкуренции у нас запущены параллельные процессы, которые нацелены на изменение одного и того же участка памяти.
  // И разработчику крайне важно учитывать, в какой последовательности происходят изменения.

  // Самым популярным примером является работа с банковским счетом.
  // Создадим класс, который позволит нам открыть счет в банке

  class BankAccount(var amount: Int){
    override def toString: String = s"На счету $amount"
  }
  // Вне класса определим метод, который позволит расходовать средства на счету:
  def payWithCard(account: BankAccount, price: Int, details: String) ={
    account.amount = account.amount - price
    println(details)
    println(s"Остаток на счете ${account.amount}")
  }
  // Для создания состояния гонки пропишем код, запускающий два параллельных процесса по покупке футболок и ботинок
  val b = for(_ <- 1 to 50){
    val account = new BankAccount(100)
    val thread1 = new Thread(() => payWithCard(account, 20, "футболка"))
    val thread2 = new Thread(() => payWithCard(account, 20, "ботинки"))
    thread1.start()
    thread2.start()
    Thread.sleep(10)
    if(account.amount != 30) println(s"Остаток на счете: ${account.amount}")
  }


  // Инкапсуляция работает только для модели с одним Thread
  // Ожидается, что раз у нас 5 процессов, которые пополняют баланс, и 5 процессов, которые расходуют баланс,
  // то в конечном итоге у нас будет та же сумма, с которой мы начали, но это не так.

  class Account(private var amount: Int) {
    def deposit(money: Int) = this.amount += money
    def withdraw(money: Int) = this.amount -= money

    def balance = amount
  }

  val account = new Account(10)

  for(_ <- 1 to 5) {
    new Thread(() => account.deposit(1)).start()
  }

  for(_ <- 1 to 5) {
    new Thread(() => account.withdraw(1)).start()
  }

  println(account.balance)

  // Для решения проблемы конкруенции подойдет синхронизация доступа

  // использование .synchronized - тогда никакие потоки не смогу одновременно получить доступ к аргументу synchronized
  def synchronizedPayment(account: BankAccount, price: Int, thing: String) = {
    account.synchronized{
      account.amount -= price
    }
  }
  // Теперь никаких аномалий не будет:
  for (_ <- 1 to 50) {
    val account = new BankAccount(100)

    val thread1 = new Thread(() => synchronizedPayment(account, 20, "футболка"))
    val thread2 = new Thread(() => synchronizedPayment(account, 50, "ботинки"))

    thread1.start()
    thread2.start()

    Thread.sleep(10)

    println(s"Остаток на счете ${account.amount}")
  }
  // использование @volatile перед переменной, к которой будет осуществляться доступ
  // class BankAccount(@volatile var amount: Int) {
  //    override def toString: String = s"На счету $amount"
  //  }
}
