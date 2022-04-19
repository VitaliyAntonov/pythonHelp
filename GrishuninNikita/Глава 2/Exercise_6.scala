/**
 * Напишите цикл for для вычисления произведения кодовых
 * пунктов Юникода всех букв в строке. Например, произведение
 * символов в строке "Hello" равно 9415087488L.
 */
object Exercise_6 extends App {
  val txt = scala.io.StdIn.readLine("Введите слово: ")
  var res = txt.charAt(0).toInt
  for (i <- 1 to txt.length()-1) {
    res *= txt.charAt(i).toInt
    println(res)
  }
}
