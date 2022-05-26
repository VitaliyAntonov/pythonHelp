import java.io._

/**
 * Дополните пример сериализуемого класса Person из раздела 9.8
 * «Сериализация» возможностью сохранения коллекции друзей.
 * Создайте несколько объектов Person, сделайте некоторые из
 * них друзьями других и затем сохраните массив Array[Person] в файл.
 * Прочитайте массив из файла и проверьте, не потерялись ли связи между друзьями.
 */
@SerialVersionUID(42L) class Person(val name : String) extends Serializable{
  private val friends = new scala.collection.mutable.ArrayBuffer[Person]
  def addFriend(nick : Person) {friends += nick}
}
object Exercise_10 extends App {
  val fred = new Person("Fred")
  val nikita = new Person("Nikita")
  val mary = new Person("Mary")
  fred.addFriend(mary)
  nikita.addFriend(fred)
  val persons = Array(fred, nikita, mary)
  val out = new ObjectOutputStream(new FileOutputStream("C:\\Users\\PROFESIONAL\\IdeaProjects\\Chapter_9\\src\\main\\scala\\txtFiles\\exercise_10.obj"))
  out.writeObject(fred)
  out.close()
  val in = new ObjectInputStream(new FileInputStream("C:\\Users\\PROFESIONAL\\IdeaProjects\\Chapter_9\\src\\main\\scala\\txtFiles\\exercise_10.obj"))
  val Array(newfred, newnikita, newmary) = in.readObject().asInstanceOf[Array[Person]]
  in.close()
  //Exception in thread "main" java.lang.ClassCastException: class Person cannot be cast to class [LPerson; (Person and [LPerson; are in unnamed module of loader 'app')
}
