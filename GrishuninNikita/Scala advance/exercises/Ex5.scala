package exercises

object Ex5 extends App {
  def add(x: Int, y: => Int) = x + y
  def multiply(f: () => Int) = f() * 2
  def four: Int = 4
  def two(): Int = 2
  add(1, four)
  add(two(), four)
  add(1, 2)
  multiply(two)
  add(1, (() => 2)())
  multiply(two _)
  multiply(() => 4)

}
