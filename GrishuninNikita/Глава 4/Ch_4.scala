object Ch_4 extends App {
  val scores = Map("Alice" -> 10, "Bob" -> 2, "Clindy" -> 5) //Ассоциативный неизменяемый массив, пара значений
  val scores2 = scala.collection.mutable.Map("Alice" -> 10, "Bob" -> 2, "Clindy" -> 5) //Ассоциативный ихменяемый массив
  val scores3 = new scala.collection.mutable.HashMap[String, Int] //Пустой ассоциативный массив
  val scores4 = Map(("Alice", 10), ("Bob", 4), ("Clindy", 20)) // Альтернативый способ создания ассоциативного массива
  //Оператор -> немного проще воспринимается глазом, чем скобки
  val bobsScore = if(scores.contains("Bob")) scores("Bob") else 0 //contains - проверка на наличие ключа
  val bobsScore1 = scores.getOrElse("Bob", 0) // Сокращенная форма записи, если содержит "Bob", вернет значение, иначе вернет 0
  val scores5 = scores.withDefaultValue(0)
  val zeldasScore5 = scores5.get("Zelda") // Вернет 0, потому что ключ "Zelda" отсутствует
  val scores6 = scores.withDefault(_.length)
  val zeldasScore6 = scores6.get("Zelda")  // Вернет 5, применив функцию length к отсутствующему ключу
  //Для изменения или добавления значений массива можно использоваться () слева от знака =
  scores2("Bob") = 15 // Изменения происходит только в случае того что массив является изменяемым
  scores2("Fred") = 20 // Добавление новой записи
  scores2 +=("Ivan" -> 10, "Fred" -> 7) // Добавление сразу нескольких ассоциаций при помощи +=
  scores2 -=("Alice") // Удаление значения при помощи -=
  // Изменить неизменямый массив невозможно, можно создать новый, содержащий необходимые изменения
  val newScores = scores + ("Ivan" -> 10, "Fred" -> 7) // Новый массив
  // Аналогично с удалением необходимых данных
  val newScores2 = scores - ("Alice")
  // Чтобы обойти элементы ассоц.массива можно воспользоваться следующим циклом:
  //for((k, v) <- scores) // обработка k - key/ключ и v - value/значение, массива scores
  // Если необходимо обойти ключи или значения можно использоваться методы keySet и values.
  val scrset = scores.keySet // Возвращает множество Set("Bob", "Alice", "Fred)
  for (v<- scores.values) println(v) // Выведет все значения ключей
  val invscr = for((k, v) <- scores) yield (v,k) //Меняет ключи и значения местами
  val scrtree = scala.collection.immutable.SortedMap("Alice"-> 2, "Fred" -> 3, "Bob"-> 5) // Неизменяемое дерево/отсортированный массив
  //Если потребуется выполнить обход ключей в порядке их добавления, можно использовать LinkedHashMap.
  val months = scala.collection.mutable.LinkedHashMap("January" -> 1,
    "February" -> 2, "March" -> 3, "April" -> 4, "May" -> 5)
  // Если ассоциативный массив получен в результате вызова Java метода, его можно преобразовать в соответствующий Scala-эквивалент
  // При помощи import scala.collection.JavaConversions.mapAsScalaMap, далее инициируйте преобразование, указав тип массива
  // val scores: scala.collection.mutable.Map[String, Int] = new java.util.TreeMap[String, Int]
  // Кроме того, поддерживается преобразование java.util.Properties в Map[String, String] :
  // import scala.collection.JavaConversions.propertiesAsScalaMap
  // val props: scala.collection.Map[String, String] = System.getProperties()
  // Чтобы передать ассоциативный массив Scala в метод, принимающий ассоциативный массив Java
  // import scala.collection.JavaConversions.mapAsJavaMap
  // import java.awt.font.TextAttribute._  Импортировать ключи
  // val attrs = Map(FAMILY -> "Serif", SIZE -> 12) ассоциативный массив Scala
  // val font = new java.awt.Font(attrs)  Принимает ассоциативный массив Java

  //Кортежи - заключение отдельных значений в круглые скобки
  val crt = ((1,3.14, "Fred"), (5,5.14, "Bob"), (155,3, "Bread")) // кортеж типа [Int, Double, java.lang.String]
  //Для обращения к компонентам кортежа можно воспользоваться методами _1,_2,_3
  val second = crt._2 // В кортежах нумерация позиций компонентов начинается с 1, а не с 0
  // Обычно для доступа к компонентам кортежа лучше использоваться механизм сопоставления с образцом
  val (first, scnd, third) = crt // присовит переменной first - 1, scnd - 3.14, third - Fred
  //Вместо ненужных компонентов можно использоваться _
  val (frst, sec, _) = crt
  // Функция zip - обьединяет значения, которые должны обрабатываться вместе
  val symbols = Array("<", "-", ">")
  val counts = Array(2, 10, 2)
  val pairs = symbols.zip(counts) // создат массив пар Array(("<", 2), ("-", 10), (">", 2))




}
