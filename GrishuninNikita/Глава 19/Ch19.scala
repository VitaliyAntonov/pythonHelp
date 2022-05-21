import javax.swing.JComponent
import scala.collection.mutable.ArrayBuffer

object Ch19 {
  // Типы-одиночки
  class Document {
    def setTitle(title: String): this.type = { this } // this.type позволяет создавать цепочки вызовов
    def setAuthor(author: String): this.type = { this }
  }
  class Book extends Document{
    def addChapter(chapter: String) = { this }
  }
  val article = new Document
  article.setTitle("Whatever Floats Your Boat").setAuthor("Cay Horstmann")
  val book = new Book
  book.setTitle("Scala").addChapter("S2")// Без this.type у set.title не будет работать, так как возвращаемое значение типа Document не содержит метод addChapter

  //Тип одиночка
  object Title{
    class Document{
      private var useNextArgAs: Any = null
      def set(obj: Title.type): this.type = { useNextArgAs = obj; this} //Аргументом метода является объект одиночка
      // obj: Title.type
    }
  }
}
// Проекции типов
object Type{
  import scala.collection.mutable.ArrayBuffer
  class Network {
    class Member(val name: String) {
      val contacts = new ArrayBuffer[Network#Member]
    }
    private val members = new ArrayBuffer[Member]
    def join(name: String) = {
      val m = new Member(name)
      members += m
      m
    }
  }
  // В данном случае каждый экземпля класса Network будет иметь свой класс Member, например:
  val chatter = new Network // chatter.member и myFace.member это два разных класса
  val myFace = new Network
  val fred = chatter.join("Fred") // Имеет тип chatter.Member
  val barney = myFace.join("Barney") // Имеет тип myFace.Member
  fred.contacts += barney //- невозможно так как разные типы
  // Чтобы избежать этого можно либо вынести определение класса Member за пределы Network
  // либо воспользоваться проекцией типа Network#Member, которая означает Member of any Network (член любого сообщества)
}
// Псеводнимы типов
object PsType{
  class Book{
    import scala.collection.mutable._
    type Index = HashMap[String, (Int, Int)] // С помощью type можно создавать простые псевдонимы для сложных имен типов
    // Теперь для ссылки на громоздкое имя типа scala.collection.mutable.HashMap[String, (Int, Int)] можно использовать Book.Index
  }
  // Определение псевдонима типа (type alias) должно вкладываться в класс или объект.
}

// Стуктурные типы
object StrType{
  def appendLines(target: { def append(str:String): Any}, lines: Iterable[String]): Unit = {
    for (l<- lines) {target.append(l); target.append("\n")}
  }
  // Метод appendLines имеет параметр структурного типа, ему можно передать экземпляр любого типа, обладающего
  // методом append
}

// Составные типы
// Составной тип имеет вид Type1  with Type2 with Type3 ...
// Type это типы, чтобы принадлежать составному типу значение должно принадлежать каждому отдельно взятому типу.
object SostType{
  import java.awt._
  import java.awt.geom._
  import scala.collection.mutable.ArrayBuffer
  val image = new ArrayBuffer[java.awt.Shape with java.io.Serializable] // Составной тип
  val rect = new Rectangle(5, 10, 20, 30)
  image += rect // OK — Rectangle реализует интерфейс Serializable
  //image += new Area(rect) // Ошибка: Area реализует Shape, но не Serializable
  // Имеется возможность добавлять объявления структурных типов в простые и составные типы
}
// Инфиксные типы
object InfType{
  //Инфиксный тип – это тип с двумя параметрами типов, определение которого записывается в «инфиксной» нотации, когда имя
  //определяемого типа помещается между параметрами типов.
  //Например вместо Map[String, Int] можно записать String Map Int

  // Экзистенциальные типы
  // Это выражение типа, за которым следует конструкция forSome{...}, где фигурные скобки окружают объявления type и val
  // Например Array[T] forSome{type T<: JComponent}
  // Это тоже самое что подстановочный тип Array[_ <: JComponent]
  // Конструкция forSome позволяет определять более сложные отношения, чем можно выразить с применением подстановочного символа
  // Например Map[T, U] forSome { type T; type U <: T }
  //Само по себе это определение не представляет большого интереса – вместо него можно было бы использовать простую проекцию
  //типа Network#Member.
  class Network {
    class Member(val name: String) {
      val contacts = new ArrayBuffer[Network#Member]
    }
    private val members = new ArrayBuffer[Member]
    def join(name: String) = {
      val m = new Member(name)
      members += m
      m
    }
  }
  def proccess [M <: n.Member forSome {val n: Network}](m1: M, m2: M) = (m1, m2)// Этот метод будет принимать членов одного сообщества и отвергать членов разных сообществ
  val chatter = new Network
  val myFace = new Network
  val fred = chatter.join("Fred")
  val wilma = chatter.join("Wilva")
  val barney = myFace.join("Barney")
  proccess(fred, wilma) // Всё ок
  //proccess(fred, barney) // Ошибка
}

// Собственные типы
object SType{
  // Трейт может требовать, чтобы класс, в который он подмешивается, наследовал другой тип
  // Для этого трейт определяется с объявлением собственного типа this: Type =>
  // Такой трейт сможет подмешиваться только в подклассы указанного типа
  trait Logged {
    def log(msg: String)
  }
  trait LoggedException extends Logged{ // Трейт который можно подмешивать лишь в классы, наследующие класс Exception
    this: Exception =>
    def log() {log(getMessage())}
    // Можно вызвать getMessage потому что это Exception
  }
}