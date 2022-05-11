/**
 * Пусть имеется список lst целых чисел, что означает выражение
 * (lst :\ List[Int]())(_ :: _)? - Означает foldRight
 * (List[Int]() /: lst)(_ :+ _)? - Означает foldLeft
 * Что можно изменить здесь, чтобы перевернуть список? .reverse
 */
object Exercise_6 extends App {
 val lst = List[Int](1, 2, 3, 4, 5)
 println((lst :\ List[Int]())(_ :: _).reverse)
 println((List[Int]() /: lst)(_ :+ _).reverse)
}
