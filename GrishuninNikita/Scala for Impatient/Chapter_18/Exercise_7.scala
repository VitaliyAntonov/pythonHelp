/**
 * Посмотрите список методов трейта Iterable[+A].
 * Какие из них используют параметр типа A?
 * def collect[B](pf: PartialFunction[A, B]): Iterable[B]
 * def corresponds[B](that: IterableOnce[B])(p: (A, B) => Boolean): Boolean
 * def count(p: (A) => Boolean): Int
 * def dropWhile(p: (A) => Boolean): Iterable[A]
 * def empty: Iterable[A]
 * Их очень много
 */

object Exercise_7 extends App {
}
