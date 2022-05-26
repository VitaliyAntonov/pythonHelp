/**
 *  Компилятор Scala трансформирует выражение for/yield
 *  for (i <- 1 to 10; j <- 1 to i) yield i * j в вызовы flatMap и map, как показано ниже:
 *  (1 to 10).flatMap(i => (1 to i).map(j => i * j))
 *  Объясните, когда используется flatMap.
 *  flatMap необходим для объединения коллекции в одну строку и применения функции ко всем элементам коллекции
 */
object Exercise_9 extends App {
}
