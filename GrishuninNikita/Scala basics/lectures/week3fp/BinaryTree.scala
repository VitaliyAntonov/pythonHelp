package lectures.week3fp

object BinaryTree {
  abstract class BinaryTree[+T] {
    def value: T // значение узла
    def leftChild: BinaryTree[T] // левый потомок
    def rightChild: BinaryTree[T] // правый потомок
  }
  // Узлы дерева
  case class Node[+T](
                       override val value: T,
                       override val leftChild: BinaryTree[T],
                       override val rightChild: BinaryTree[T])
    extends BinaryTree[T]

  // leaf
  case object TreeEnd extends BinaryTree[Nothing] {
    override def value: Nothing = throw new NoSuchElementException
    override def leftChild: BinaryTree[Nothing] = throw new NoSuchElementException
    override def rightChild: BinaryTree[Nothing] = throw  new NoSuchElementException
  }

  val tree = Node(1,
    Node(2,
      Node(4,
        TreeEnd,
        TreeEnd),
      Node(5,
        TreeEnd,
        Node(8,
          TreeEnd,
          TreeEnd))),
    Node(3,
      Node(6,
        TreeEnd,
        TreeEnd),
      Node(7,
        TreeEnd,
        TreeEnd)))
}
