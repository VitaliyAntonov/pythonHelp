/**
 * Импортируйте java.awt.datatransfer._ и создайте объект типа SystemFlavorMap вызовом
 * val flavors = SystemFlavorMap.getDefaultFlavorMap().
 * asInstanceOf[SystemFlavorMap]
 * Затем вызовите метод getNativesForFlavor с параметром DataFlavor.imageFlavor
 * и получите возвращаемое значение как буфер Scala. (
 * Зачем нужен этот непонятный класс?
 * Довольно сложно найти пример использования java.util.List в стандартной библиотеке Java.)
 */
import java.awt.datatransfer._
import scala.collection.mutable.ArrayBuffer
object Exercise_11 extends App {
  val flavors = SystemFlavorMap.getDefaultFlavorMap().asInstanceOf[SystemFlavorMap]
  val buff = flavors.getNativesForFlavor(DataFlavor.imageFlavor)
  println(buff)
}
