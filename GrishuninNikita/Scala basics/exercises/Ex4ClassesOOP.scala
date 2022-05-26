package exercises

object Ex4ClassesOOP extends App {
  class Instructor(val id: Int, val name: String, val surname: String){
    def fullName(): String = s"$name".take(1).toUpperCase() + s"$name".substring(1) + " " +s"$surname".take(1).toUpperCase() + s"$surname".substring(1)
  }
  class Course(val courseID: Int, val title: String, val releaseYear: String, val instructor: Instructor){
    def getID = s"$courseID" + s"${instructor.id}"
    def isTaughtBy(instructor: Instructor) = if(instructor == this.instructor) true else false
    def copyCourse(newReleaseYear: String) = new Course(this.courseID, this.title, newReleaseYear, this.instructor)
  }
}
