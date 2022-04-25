/**
 *  Создайте класс Car со свойствами, определяющими производителя,
 *  название модели и год производства, которые доступны только для чтения,
 *  и свойство с регистрационным номером автомобиля, доступным для чтения/записи.
 *  Добавьте четыре конструктора. Все они должны принимать название производителя и название модели.
 *  При необходимости в вызове конструктора могут также указываться год и регистрационный номер.
 *  Если год не указан, он должен устанавливаться равным -1, а при отсутствии регистрационного
 *  номера должна устанавливаться пустая строка.
 */
object Exercise_8 extends App {
  class Car(mnf: String, mdl : String){
    private var year = -1
    var regnum = " "
    def this(mnf: String, mdl: String, year: Int){
      this(mnf, mdl)
      this.year = year
    }
    def this(mnf: String, mdl: String, regnum: String){
      this(mnf, mdl)
      this.regnum = regnum
    }
    def this(mnf: String, mdl: String, year: Int, regnum: String){
      this(mnf, mdl)
      this.year = year
      this.regnum = regnum
    }
  }
  val car = new Car("Toyota", "Mark 2 JZX 100")
  val car1 = new Car("Toyota", "Mark 2 JZX 100", 1989)
  val car2 = new Car("Toyota", "Mark 2 JZX 100", "9928566462")
  var car3 = new Car("Toyota", "Mark 2 JZX 100", 1989, "23775661552")
}
