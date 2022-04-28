
/**
 * Определите абстрактный класс элемента Item с методами price и description.
 * Определите подкласс простого элемента SimpleItem, представляющий элемент,
 * цена и описание которого определяются в конструкторе. Используйте тот факт,
 * что объявление val может переопределять def. Определите класс Bundle – пакет элементов,
 * содержащий другие элементы. Его цена должна определяться как сумма цен элементов в пакете.
 * Реализуйте также механизм добавления элементов в пакет и соответствующий метод description.
 */
import scala.collection.mutable.ArrayBuffer
object Exercise_4 extends App{
  abstract class Item{
    val price: Int
    var description : String
  }
  class simpleItem(prc: Int, descp: String) extends Item{
    override val price = prc
    override var description = descp
  }
  class Bundle{
    var bundle = ArrayBuffer[simpleItem]()
    def additem(item : simpleItem): Unit ={
      bundle += item
    }
    def price : Unit = {
      bundle.foldLeft(0)(_+_.price)
    }
    def description : Unit ={
      bundle.map(_.description).mkString(", ")
    }

  }
  val bnd = new Bundle
  bnd.additem(new simpleItem(25, "nikita"))
  bnd.additem(new simpleItem(20,"ivan"))
  }
