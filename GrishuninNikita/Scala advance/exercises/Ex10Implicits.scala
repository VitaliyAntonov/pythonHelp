package exercises

object Ex10Implicits extends App {
  case class Course(id: Int, title: String)

  val courses = List(
    Course(0, "Scala"),
    Course(1, "Advanced Scala"),
    Course(4, "Spark"),
    Course(3, "Cats")
  )
  implicit val courseOrdering: Ordering[Course] = Ordering.by(c => (c.id, c.title))
  println(courses.sorted)
}
