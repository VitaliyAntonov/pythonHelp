/**
 * Приведите пример, демонстрирующий, почему оптимизация хвостовой рекурсии не может быть произведена,
 * если метод допускает возможность переопределения.
 */
object Exercise_7 extends App{
  import scala.annotation.tailrec
  //@tailrec def sum(xs: Seq[Int]): BigInt =
    //if (xs.isEmpty) 0 else xs.head + sum(xs.tail)
  //println(sum(a))
  @tailrec def sum2(xs: Seq[Int], partial: BigInt): BigInt =
    if (xs.isEmpty) partial else sum2(xs.tail, xs.head + partial)
  val a = Seq(1, 2, 3, 4, 5)
  println(sum2(a, 0))
}

