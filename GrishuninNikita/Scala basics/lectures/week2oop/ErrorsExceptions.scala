package lectures.week2oop

object ErrorsExceptions extends App{
  // Ошибки
  // StackOverflowError (с ней мы имели дело в теме рекурсий) ошибка связана со stack памятью,
  // которая задействуется при вызове метода (под каждый вызов метода в стеке создается новый блок,
  // хранящий информацию о параметрах, переменных метода).
  // OutOfMemoryError также намекает, что мы исчерпали доступную нам память.
  // Например, если в массиве вдруг стало слишком много элементов. Только в этот раз ошибка связана с heap памятью,
  // которая используется при выделении памяти под объекты)

  // Исключения - дают знать что не так с вашей программой
  // NullPointerException - возникает, если мы пытаемся получить доступ к чему-то, чего нет
  val x: String = null
  println(x.length) // NullPointerException
  // RuntimeException - бросается, когда необходимо указать на какие-то логические ошибки программы
  // Если в коде необходимо бросить исключение - достаточно использовать ключевое слово throw (за которым должно следовать new).
  //throw new NullPointerException

  // try-catch-finally поможет поймать исключение
  def intOrNothing(hasException: Boolean) = {
    if(hasException) throw new RuntimeException("Exception is here")
    else 200
  }
  try{
    intOrNothing(true) // try содержит код, который потенциально может выдать исключение
  } catch{
    case e: RuntimeException => println("RTE is here") // catch содержит все возможные исключения и как на них реагировать
  } finally{
    println("I will be there no matter what") // содержит код, который исполнится в любом случае
  }
  // в идеале finally не должен содержать в себе ничего, кроме побочных эффектов ( информации для логов т.е. принты или запись инфы в файл, либо закрытие ресурсов после завершения работы с ними, например, закрытие файлов или соединения с базами данных)

  // Создание собственного исключения
  class MyException extends Exception
  val exception = new MyException
  throw exception

  // Тип Any
  val potentialException = try { // Тут будет тип Any так как try возвращает int catch unit
    intOrNothing(false)
  } catch {
    case e: RuntimeException => println("RTE is here")
  } finally {
    println("I will be there no matter what")
  }
}
