/**
 * Сравните:
 * <li>Fred</li> match { case <li>{Text(t)}</li> => t }
 * и
 * <li>{"Fred"}</li> match { case <li>{Text(t)}</li> => t }
 */
import scala.xml._

object Exercise_3 extends App{
  val xml = <li>Fred</li> match {
    case <li>{Text(t)}</li> => t
  }
  val xml2 = <li>{Text("Fred")}</li> match { //{"Fred"} компилятор считает эту часть встроенным scala-кодом а не xml
    case <li>{Text(t)}</li> => t
  }
  println(xml)
  println(xml2)
}
