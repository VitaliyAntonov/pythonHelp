/**
 * Язык Scala позволяет умножать строки на числа – попробуйте
 * выполнить выражение "crazy" * 3 в REPL. Что получилось
 * в результате? Где в Scaladoc можно найти ее описание?
 * В результате выполнения выражения выводится crazycrazycrazy.
 * Описание в Scaladoc можно найти в StringOps: def*(n: Int): String
 * Return the current string concatenated n times.
 */
object Exercise_4 extends App {
val x : String = "crazy"
  println(x*3)
}
