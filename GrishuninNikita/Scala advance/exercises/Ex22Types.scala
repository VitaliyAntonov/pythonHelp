package exercises

object Ex22Types extends App {
  trait SafeType {
    type Key
  }

  trait Record[T] extends SafeType{
    type Key  = T // строго заданные тип
  }

  trait IntRecord extends Record[Int]
  trait StringRecord extends Record[String]

  def extractor[RecordType <: SafeType](key: RecordType#Key): Unit = println(key)
}
