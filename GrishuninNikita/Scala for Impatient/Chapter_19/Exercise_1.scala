/**
 * Реализуйте класс Bug, моделирующий жука, перемещающегося по горизонтальной линии.
 * Метод move перемещает жука в текущем направлении, метод turn изменяет
 * направление на противоположное, а метод show выводит текущую позицию.
 * Обеспечьте возможность составления цепочек из вызовов этих методов.
 */
object Exercise_1 extends App{
  class Bug{
    var step = 0
    var trn = 1

    def move(n: Int): Bug = {
      if(trn == 1) step += n else step -= n
      this
    }
    def show(): Bug = {
     println(step)
     this
    }
    def turn(): Bug = {
      trn = 0
      this
    }
  }
  new Bug().move(4).show().move(6).show().turn().move(5).show()
}
