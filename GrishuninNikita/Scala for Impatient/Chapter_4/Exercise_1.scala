/**
 * Создайте ассоциативный массив с ценами на вещи, которые вы
 * хотели бы приобрести. Затем создайте второй ассоциативный
 * массив с теми же ключами и ценами с 10%-ной скидкой.
 */


object Exercise_1 extends App{
  val price = Map("Personal Computer" -> 500, "T-shirt" -> 20, "Coffee" -> 10)
  val price2 = for((k,v) <- price) yield (k,((v*90)/100))
  println(price.mkString(", "), price2.mkString(", "))
}
