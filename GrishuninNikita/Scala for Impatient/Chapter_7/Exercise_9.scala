/**
 *  Напишите программу, импортирующую класс java.lang.System,
 *  читающую имя пользователя из системного свойства user.name,
 *  пароль из объекта Console и выводящую сообщение в стандартный
 *  поток ошибок, если пароль недостаточно «секретный».
 *  В противном случае программа должна вывести приветствие в стандартный поток вывода.
 *  Не импортируйте ничего другого и не используйте полных квалифицированных имен (с точками).
 */
import java.lang.System
object Exercise_9 extends App{
  val name = System.getProperty("user.name")
  println(name)
  val password = System.console.readPassword() //Exception in thread "main" java.lang.NullPointerException
  println(password)

}