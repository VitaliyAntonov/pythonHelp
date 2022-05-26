import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

/**
 * Рассмотрите выражение
 * for (n1 <- Future { Thread.sleep(1000) ; 2 }
 * n2 <- Future { Thread.sleep(1000); 40 })
 * println(n1 + n2)
 * Как это выражение преобразуется в вызовы методов map и flatMap?
 * Как выполняются задания Future, параллельно или последовательно? Они выполняются параллельно
 * В каком потоке произойдет вызов println? Во втором потоке
 *
 */
object Exercise_1 extends App{
  val future1 = Future { Thread.sleep(1000) ; 2 }
  val future2 = Future { Thread.sleep(1000); 40 }
  val combined = future1.map(n1 => future2.map(n2 => n1 + n2))
  val combined2 = future1.flatMap(n1 => future2.map(n2 => n1 + n2))
}
