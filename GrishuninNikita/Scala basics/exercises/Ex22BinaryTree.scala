package exercises

object Ex22BinaryTree extends App {
  abstract class BinaryTree[+T] {
    def value: T
    def leftChild: BinaryTree[T]
    def rightChild: BinaryTree[T]

    def isEmpty:  Boolean
    def isLeaf: Boolean
  }

  case class Node[+T](
                       override val value: T,
                       override val leftChild: BinaryTree[T],
                       override val rightChild: BinaryTree[T])
    extends BinaryTree[T] {

    override def isEmpty: Boolean = false
    override def isLeaf: Boolean = leftChild.isEmpty && rightChild.isEmpty
  }

  case object TreeEnd extends BinaryTree[Nothing] {
    override def value: Nothing = throw new NoSuchElementException
    override def leftChild: BinaryTree[Nothing] = throw new NoSuchElementException
    override def rightChild: BinaryTree[Nothing] = throw  new NoSuchElementException

    override def isEmpty: Boolean = true
    override def isLeaf: Boolean = false
  }
}

