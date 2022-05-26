/**
 * Реализуйте класс IterableInputStream, наследующий java.io.InputStream и подмешивающий трейт Iterable[Byte]
 */
object Exercise_11 extends App {
  class IterableInputStream(is: java.io.InputStream) extends Iterable[Byte]{
    override def iterator: Iterator[Byte] = new Iterator[Byte]{
      override def hasNext: Boolean = is.available() > 0
      override def next: Byte = is.read().toByte
    }
  }
  val iter = new IterableInputStream(new java.io.FileInputStream("C:\\Users\\PROFESIONAL\\IdeaProjects\\Chapter_10\\src\\main\\scala\\exercise_9.txt"))
  val it = iter.iterator.map(_.toChar)
  println(it.mkString)
}

