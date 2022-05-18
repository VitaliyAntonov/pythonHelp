import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Await, Future}
import scala.concurrent.duration.DurationInt

/**
 * Напишите программу, подсчитывающую количество простых чисел между 1 и n с использованием BigInt.isProbablePrime.
 * Разбейте интервал на p частей, где p – количество доступных процессоров (ядер).
 * Подсчитайте количество простых чисел в каждой части с помощью заданий Future, выполняющихся
 * параллельно, и объедините полученные результаты.
 */
object Exercise_7 extends App{
  def func(n: BigInt): Future[Int] = {
    val p = Runtime.getRuntime.availableProcessors()
    (BigInt(1) to n)
      .grouped((n / p).toInt)
      .map(g=> Future{g.count(_.isProbablePrime(100))})
      .reduce((af, bf) => {for(a <- af; b <- bf) yield a + b})
  }
  println(Await.result(func(25), 10.seconds))
}
