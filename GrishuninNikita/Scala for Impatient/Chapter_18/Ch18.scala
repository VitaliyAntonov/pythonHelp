object Ch18 {
  class Pair[T,S](val first: T, val second: S) // Объявление параметризованных типов(T, S)
  //Класс с одним и более параметров называется обобщенным
  val b = new Pair("Ss", 2)// Компилятор выводит фактические типы, это - Pair[String, Int]
  // Также можно объявлять явно типы
  val b2 = new Pair[Any, Any](42,"String")
  def getMiddle[T](a: Array[T]) = a(a.length / 2) // Обобщенная функция
  val b3 = getMiddle(Array("M", "s", "2")) // Также выводит фактические типы
  // Их также можно объявлять явно
  val b4 = getMiddle[String](Array("n", "2"))
  // Можно ограничить диапазон изменения типов
  class Pair2[T<: Comparable[T]](val first: T, val second: T){
    //[T<: Comparable[T]] - тип объектов с которыми можно сравнивать, определение верхней границы типа
    def smaller = if (first.compareTo(second) < 0) first else second //compareto сравнение first с second
  }
  // Также можно определить нижнюю границу типа.
  class Pair3[T](val first: T, val second: T) {
    def replaceFirst(newFirst: T) = new Pair3[T](newFirst, second) // Замещение первого значения Pair
    def replaceFirstTR[R>:T](newFirst: R) = new Pair3[R](newFirst, second) // Замена экземляра типа T экземпляром типа R
    // Возвращаемый тип должен быть супертипом для типа компонента пары, возвращаемым типом будет Pair3[R]
  }
  //Границы представления, Class Pair[T <% Comparable[T]] - Отношение <% означает, что тип T может быть преобразован в тип
  //Comparable[T] посредством неявного преобразования.

  //Границы контекста
  class Pair4[T: Ordering](val first: T, val second: T){ // [T: Ordering] - определенеи границ контекста
    // ordering это другой обобщенный тип. для этого требуется наличие неявного значения типа Ordering[T]
    def smaller(implicit orв:Ordering[T]) = { //implicit - неявный параметр
      if (orв.compare(first, second) < 0) first else second
    }
  }
  // Границы контекста ClassTag
  import scala.reflect._
  def makePair[T: ClassTag](first: T, second: T) = {
    val r = new Array[T](2); r(0) = first; r(1) = second; r
    // тобы создать экземпляр обобщенного класса Array[T], необходим объект ClassTag[T].
    // Это требуется для корректной работы массивов простых типов.
    // Например, если T – это тип Int, в виртуальной машине должен быть создан массив int[].
  }
  // Множественные границы
  // Тип может иметь сразу обе границы, верхнюю и нижнюю
  // T <: Upper >: Lower - определение обоих границ
  // Можно указывать несколько границ T : Ordering : ClassTag

}
