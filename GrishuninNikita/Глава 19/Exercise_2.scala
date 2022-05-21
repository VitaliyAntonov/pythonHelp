/**
 * Реализуйте «свободный» интерфейс для класса Bug из предыдущего упражнения, чтобы можно было записать:
 * bug move 4 and show and then move 6 and show turn around move 5 and show
 */
object Exercise_2 {
  object show{}
  object then{}
  object around{}

  class Bug{
    var step: Int = 0
    var trn: Int = 1

    def move(n: Int): Bug = {
      if(trn == 1) step += n else step -= n
      this
    }
    def show(): Bug = {
     println(step)
     this
    }
    def turn(obj: around.type): Bug = {
      trn = 0
      this
    }
    def turn(): Bug ={
      trn = 0
      this
    }
    //def and(obj: show.type): Bug = this.show()
    //def and(obj: then.type): Bug = this
  }
  val bugsy = new Bug()
  //bugsy move 4 and show and then move 6 and show turn around move 5 and show
}
