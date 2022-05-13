/**
 * Добавьте case-класс Multiple, наследующий класс Item.
 * Например, Multiple(10, Article("Blackwell Toaster", 29.95)) описывает десять тостеров.
 * Разумеется, должна предусматриваться возможность обрабатывать любые элементы, такие как пакет
 * или множитель, во втором аргументе.
 * Расширьте функцию price, чтобы она могла обрабатывать этот новый класс.
 */
object Exercise_4 extends App{
  abstract class Item
  case class Article(description: String, price: Double) extends Item
  case class Bundle(description: String, discount: Double, items: Item*) extends Item
  case class Multiple(c: Int, item:Item) extends Item

  def price(it: Item): Double = it match {
    case Article(_, p) => p
    case Bundle(_, disc, its @ _*) => its.map(price _).sum - disc
    case Multiple(c, i) => c * price(i)
  }
  val a = Article("Scala for the Impatient", 39.95)
  val b = Bundle("Anchor Distillery Sampler", 10.0,
    Article("Old Potrero Straight Rye Whiskey", 79.95),
    Article("Junípero Gin", 32.95))
  val m = Multiple(10, a)
  val m2 = Multiple(20, b)
  println(price(m)+ "  " + price(m2))
}
