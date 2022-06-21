package exercises

object Ex25Reflection extends App {
  def determineClass[T](instance: T): String = instance.getClass.getSimpleName
}
