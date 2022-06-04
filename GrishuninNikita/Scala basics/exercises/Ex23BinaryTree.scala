package exercises

object Ex23BinaryTree extends App {
  abstract class BinaryTree[+T] {
    def value: T

    def leftChild: BinaryTree[T]

    def rightChild: BinaryTree[T]

    def isEmpty: Boolean

    def isLeaf: Boolean

    def collectLeaves: List[BinaryTree[T]]
  }

  case object TreeEnd extends BinaryTree[Nothing] {
    override def value: Nothing = throw new NoSuchElementException

    override def leftChild: BinaryTree[Nothing] = throw new NoSuchElementException

    override def rightChild: BinaryTree[Nothing] = throw new NoSuchElementException

    override def isEmpty: Boolean = true

    override def isLeaf: Boolean = false

    override def collectLeaves: List[BinaryTree[Nothing]] = List()
  }

  case class Node[+T](
                       override val value: T,
                       override val leftChild: BinaryTree[T],
                       override val rightChild: BinaryTree[T])
    extends BinaryTree[T] {

    override def isEmpty: Boolean = false

    override def isLeaf: Boolean = leftChild.isEmpty && rightChild.isEmpty

    override def collectLeaves: List[BinaryTree[T]] = {
      def loop(toInspect: List[BinaryTree[T]] = List(this), leaves: List[BinaryTree[T]] = List()): List[BinaryTree[T]] = {
        if (toInspect.isEmpty) leaves
        else if (toInspect.head.isEmpty) leaves
        else if (toInspect.head.isLeaf) leaves ++ toInspect
        else loop(toInspect.tail, leaves)
      }

      loop()
    }

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
  print(tree.collectLeaves)
}

