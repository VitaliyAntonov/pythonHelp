/**
 * Расширьте дерево из предыдущего упражнения, чтобы каждый узел, не являющийся листом,
 * вдобавок к дочерним узлам мог хранить оператор. Затем напишите функцию eval, вычисляющую значение.
 */
object Exercise_8 extends App{
  sealed abstract class BinaryTree
  case class Leaf(value: Int) extends BinaryTree
  case class Node(op: Char, leafs: BinaryTree*) extends BinaryTree
  def leaf(t: BinaryTree) : Int = t match{
    case Leaf(x) => x
    case Node('+', t  @ _*)  => t.map(leaf).sum
    case Node('*', t @_*) => t.map(leaf).product
    case Node('-', t @_*) => t.map(leaf).foldLeft(0)(_ - _)
    case _ => 0
  }
  val tree = Node('+', Node('*', Leaf(3), Leaf(8)), Leaf(2), Node('-', Leaf(5)))
  println(leaf(tree))
}
