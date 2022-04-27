/**
 * Напишите головоломку, которая смогла бы сбить с толку ваших коллег,
 * программистов на Scala, использующую пакет com, не являющийся пакетом верхнего уровня.
 */
  package horstmann{
    package com{
      class Nothing(name:String, var salary:Double){
        println(name, salary)
      }
    }
  }
object Exercise_2 {
  var l = new horstmann.com.Nothing("Nikita", 2000)
}
