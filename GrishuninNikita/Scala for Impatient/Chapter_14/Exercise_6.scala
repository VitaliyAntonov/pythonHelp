/**
 * Такие деревья лучше всего моделировать с применением case классов. Начните с бинарных деревьев.
 * Напишите функцию, вычисляющую сумму всех значений листьев.
 */
object Exercise_6 extends App{
  sealed abstract class BinaryTree
  case class Leaf(value: Int) extends BinaryTree
  case class Node(left: BinaryTree, right: BinaryTree) extends BinaryTree
  def leafSum (t: BinaryTree) : Int = t match{
    case Leaf(x) => x
    case Node(l, r) => leafSum(l) + leafSum(r)
    case _ => 0
  }
  val tree = Node(Node(Leaf(3), Node(Leaf(8), Leaf(2))), Node(Leaf(3),Leaf(5)))
  println(leafSum(tree))
}
