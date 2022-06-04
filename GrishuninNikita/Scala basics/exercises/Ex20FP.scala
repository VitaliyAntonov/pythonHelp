package exercises

object Ex20FP extends App {
  /*config.get("host").flatMap(host => config.get("port").
    flatMap(port => Connection(host, port)).map(connection => connection.connect)).foreach(println)

  val forConnectionStatus = for {
    host <- config.get("host")
      port <- config.get("port")
    connection <- Connection(host, port)
  } yield connection.connect

    forConnectionStatus.foreach(println)

  def safeConnection(host: String, port: String): Try[Connection] = Try(HttpService(host,port))
  def safeUrl(url: String): Try[Connection] = {
    connection <- Connection(host, port)
  } yield Try(connection.get(url))
  safeConnection(host, port).safeUrl("https://stepik.org/lesson/469625/step/4?unit=460451").foreach(render)
   */
}

