package exercises

object Ex18Week2 extends App {
  def compare(v1: String, v2: String): Int = {
    val pattern = """[0-9]""".r
    val a = pattern.findAllIn(v1).mkString.zipAll(pattern.findAllIn(v2).mkString, "0", "0")
    val b = for (elem <- a) yield elem._1
    val c = for (elem <- a) yield elem._2
    if (b.mkString.toInt < c.mkString.toInt) -1
    else if (b.mkString.toInt == c.mkString.toInt) 0
    else 1
  }
  println(compare("2.1", "2.01"))
  }

