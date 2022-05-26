package lectures.week2oop

object ObjectsOOP extends App {
  class MyString(val str: String) {
    private var extra = "extraData"

    def getString: String = str + extra
  }

  object MyString { // Объект компаньон класса MyString, имеет доступ ко всем его полям
    def apply(base: String, extras: String): MyString = { // Позволяет опускать име метода при вызове
      val s = new MyString(base)
      s.extra = extras// изменили поле extra класса MyString
      s
    }

    def apply(base: String) = new MyString(base)
  }

  println(MyString.apply("hello", "world").getString)
  println(MyString.apply("welcome").getString)
}
