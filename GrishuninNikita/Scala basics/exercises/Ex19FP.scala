package exercises

object Ex19FP extends App {
  /*config.get("host").flatMap(host => config.get("port").
    flatMap(port => Connection(host, port)).map(connection => connection.connect)).foreach(println)

  val forConnectionStatus = for {
    host <- config.get("host")
      port <- config.get("port")
    connection <- Connection(host, port)
  } yield connection.connect

    forConnectionStatus.foreach(println)
   */
}

