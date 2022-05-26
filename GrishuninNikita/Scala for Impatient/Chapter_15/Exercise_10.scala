/**
 * Добавьте вызов assert(n >= 0) в метод factorial.
 * Скомпилируйте, разрешив выполнение проверок, и убедитесь, что вызов factorial(-1) генерирует исключение.
 * Скомпилируйте, запретив выполнение проверок.
 */
object Exercise_10 extends App{
  def factorial(n: Int): Int = {
    //assert(n >= 0)
    if (n<0) 0
    else if (n == 0) 1
    else n * factorial(n - 1)
  }
  println(factorial(5))
  println(factorial(-5)) //Exception in thread "main" java.lang.AssertionError: assertion failed
}

