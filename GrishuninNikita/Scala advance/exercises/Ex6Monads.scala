package exercises

object Ex6Monads extends App {
  case class User(name: String, bf: User)
  val users = List(
    User("Mike", User("Sam", User("Bob", User("Alice", null)))),
    User("John", User("Joe", null)),
  )
  object Service {
    def findUser(users: List[User], name: String): List[User] = users.filter(_.name == name)
  }
  def getBf(user: User): List[User] = List(user.bf)
  val nameToFind = "John"
  val bf = Service.findUser(users, nameToFind).flatMap(getBf).flatMap(getBf)
  println(bf.map(_.name))
}
