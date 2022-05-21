/**
 * Дополните свободный интерфейс, представленный в разделе 19.1 «Типы-одиночки», чтобы можно было записать вызов:
 * book set Title to "Scala for the Impatient" set Author to "Cay Horstmann"
 */
object Exercise_3 extends App{
  object Title
  object Author

  class Document(var title: String, var author: String = " "){
    private var useNextArgAs: Any = null
    def set(obj: Title.type): this.type = { useNextArgAs = obj; this}
    def set(obj: Author.type): this.type = { useNextArgAs = obj; this}

    def to(arg: String) = {
      useNextArgAs match{
        case Title => title = arg
        case _ => "Nothing"
      }
      this
    }
  }
  val book = new Document("Scala")
  book set Title to "Scala for the Impatient" set Author to "Cay Horstmann"
}
