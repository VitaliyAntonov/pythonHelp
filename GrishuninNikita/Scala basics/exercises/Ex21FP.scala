package exercises

object Ex21FP extends App {
  def add(network: Map[String, Set[String]], location: String): Map[String, Set[String]] = network + (location -> Set())
  /*def remove(network: Map[String, Set[String]], location: String): Map[String, Set[String]] = {
    def loop(destinations: Set[String], acc: Map[String, Set[String]]): Map[String, Set[String]] = {
      if (destinations.isEmpty) acc
      else loop(destinations.tail, disconnect(acc, location, destinations.head))
      }
    //val disconnected = loop(network(location), location)
    //disconnected - location
  }*/
  def connect(network: Map[String, Set[String]], pointA: String, pointB: String): Map[String, Set[String]] = {
    val routesForA: Set[String] = network(pointA)
    val routesForB: Set[String] = network(pointB)
    network + (pointA -> (routesForA + pointB)) + (pointB -> (routesForB + pointA))
  }
  def disconnect(network: Map[String, Set[String]], pointA: String, pointB: String): Map[String, Set[String]] = {
    val routesForA: Set[String] = network(pointA)
    val routesForB: Set[String] = network(pointB)
    network + (pointA -> (routesForA - pointB)) + (pointB -> (routesForB - pointA))
  }
  def nLoactionsWithNoFlights(network: Map[String, Set[String]]): Int = network.view.filterKeys(key => network(key).isEmpty).size
  //def nFligths(network: Map[String, Set[String]], location: String): Int = network.view.maxBy(location).size
  //def mostFlightes(network: Map[String, Set[String]]): String = network.view.filterKeys(key => network(key).maxBy()

}

