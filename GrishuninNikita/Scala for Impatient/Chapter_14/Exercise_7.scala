/**
 * Расширьте дерево из предыдущего упражнения, чтобы каждый узел в нем мог иметь
 * произвольное количество дочерних узлов, и перепишите функцию leafSum.
 */
object Exercise_7 extends App{
  sealed abstract class BinaryTree
  case class Leaf(value: Int) extends BinaryTree
  case class Node(leafs: BinaryTree*) extends BinaryTree
  def leafSum (t: BinaryTree) : Int = t match{
    case Leaf(x) => x
    case Node(l  @_*) => l.map(leafSum(_)).sum
    case _ => 0
  }
  val tree = Node(Node(Leaf(3), Leaf(8)), Leaf(2), Node(Leaf(5)))
  println(leafSum(tree))
}
