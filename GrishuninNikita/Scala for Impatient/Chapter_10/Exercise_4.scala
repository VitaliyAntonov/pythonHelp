/**
 *  Реализуйте класс CryptoLogger, выполняющий шифрование сообщений с помощью алгоритма Caesar.
 *  По умолчанию должен использоваться ключ 3, но должна быть предусмотрена возможность изменить его.
 *  Напишите примеры использования с ключом по умолчанию и с ключом –3.
 */
import java.awt.Point
object Exercise_4 extends App {
  class CryptoLogger {
    val alphabet = "abcdefghijklmnopqrstuvwxyz"
    def crypt(txt: String, shift: Int):String = {
      val sh = (shift + alphabet.size) % alphabet.size // Это действие позволяет взять любое число
      txt.map((c: Char) => {
        val x = alphabet.indexOf(c.toLower)// Поиск символа в нашем алфавите
        if (x == -1) c // Если символа нет, он остается таким, каким был
        else alphabet((x + sh) % alphabet.size) // Если символ есть, он шифруется
      })
    }
  }
  val txt = "zzz"
  val cs = new CryptoLogger
  var txt2 = cs.crypt(txt, 3)
  println(txt2)
  txt2 = cs.crypt(txt2, -3)
  println(txt2)
}
