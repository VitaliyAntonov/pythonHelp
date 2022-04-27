/**
 * Напишите программу, на примере которой можно убедиться, что package com.horstmann.impatient
 * не то же самое, что и
 * package com
 * package horstmann
 * package impatient
 */


package com.horstmann.impatient{ //В данном случае члены пакетов com и horstmann недоступны
  class Employee(name: String, var salary: Double){
    val nm = name
    var salr = salary
  }
}

package com{ // В данном случае члены пакетов com и horstmann доступны
  package horstmann{
    class Nothing(name:String, var salary:Double){
      println(name, salary)
    }
  }
}
object Exercise_1 {
  val empl = new com.horstmann.impatient.Employee("Nikita", 220000)
  val empl2 = new com.horstmann.Nothing("Nikita", 2200200)
}
