package exercises

object Ex6Inheritance extends App {
  abstract class Event {
    def trigger(eventName: String): Unit
  }

  class Listener(val eventName: String, var event: Event) {
    def register(evt: Event): Unit = { event = evt }
    def sendNotification(): Unit = { event.trigger(eventName) }
  }

  val notification: Listener = new Listener("322", null)
  notification.register(new Event {
      override def trigger(eventName: String): Unit = if (eventName == "mousedown") println("trigger" + " " + s"$eventName" + " " + "event")
    }
  )
  notification.sendNotification()
}
