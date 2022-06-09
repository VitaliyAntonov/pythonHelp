package exercises

object Ex1List extends App {
 def duplicate[T](someList: List[T], nDups: Int): List[T] = {
   def loop(someList: List[T], n: Int = nDups, acc: List[T] = List()): List[T] ={
     if(n <= 0) acc
     else loop(someList.tail, n - 1, someList.head :: someList.tail)
   }
   loop(someList)
 }

  val b = List("a", "b")
  println(duplicate(b, 2))
}
