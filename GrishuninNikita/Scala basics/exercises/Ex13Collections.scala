package exercises

object Ex13Collections extends App{
  val progLanguages = List("java", "scala", "python")
  val lngAbbrev = List("JA", "SCA", "PY")
  val b = for{
    p <- progLanguages
    c <- lngAbbrev
  } yield if (p.substring(0, 2).toUpperCase == c.substring(0, 2)) (c, p)
  val out = b.filterNot(_ == ())
}
