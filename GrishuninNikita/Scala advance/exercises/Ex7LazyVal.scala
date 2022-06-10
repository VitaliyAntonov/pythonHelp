package exercises

object Ex7LazyVal extends App {
  def showString(someStr: => String): Unit = {
    lazy val lazyStr = someStr
    print(s"$lazyStr$lazyStr")
  }
}
