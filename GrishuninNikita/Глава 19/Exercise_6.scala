/**
 *  Реализуйте метод, принимающий экземпляр любого класса, который имеет метод def close(): Unit
 *  вместе с функцией обработки этого объекта. Функция должна
 *  вызывать метод close по завершении обработки или в случае какого-либо исключения.
 */
object Exercise_6 extends App{
  type close = {def close(): Unit }
  def close(close: close, f: close => Unit): Unit = {
    try{f(close)}
    finally{close.close()}
  }
}

