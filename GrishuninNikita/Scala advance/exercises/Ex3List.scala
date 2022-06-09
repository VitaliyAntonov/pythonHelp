package exercises

object Ex3List extends App {
  def isBalanced(aString: String): Boolean = {
    val pattern = """[(]""".r
    val pattern2 = """[)]""".r
    val a = pattern2.findAllIn(aString).mkString
    val b = pattern.findAllIn(aString).mkString
    if(a.length == b.length) true else false
  }
  isBalanced("gbdsfhds((")
}
