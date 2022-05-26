/**
 * Реализуйте класс Matrix – выберите сами, какую матрицу реализовать: 2×2,
 * квадратную произвольного размера или матрицу m×n.
 * Реализуйте операции + и *.
 * Последняя должна также позволять выполнять умножение на скаляр, например mat * 2.
 * Единственный элемент матрицы должен быть доступен как mat(row, col).
 */

object Exercise_8 extends App {
  class Matrix(val rows:Int, val columns: Int){
    println("Матрица: ")
    var rnd = scala.util.Random
    var matrix = Array.ofDim[Int](rows, columns)
    for(i <- 0 until rows){
      for(j<- 0 until columns){
        matrix(i)(j) = rnd.nextInt(10)
        print(matrix(i)(j) + " ")
      }
      print("\n")
    }
    def +(other: Matrix) = {
      println("Результат сложения: ")
      if(rows == other.rows && columns == other.columns){
        for(i <- 0 until rows){
          for(j<- 0 until columns){
            matrix(i)(j) += other.matrix(i)(j)
            print(matrix(i)(j) + " ")
          }
          print("\n")
        }
      } else println("Матрицы не могут быть сложены!")
    }
    def *(other: Matrix) = {
      var matrix2 = Array.ofDim[Int](rows, columns)
      var sum = 0
      println("Результат умножения: ")
      if(rows == other.columns && columns == other.rows){
        for(i<- 0 to rows-1){
          for(j<- 0 until columns -1){
            sum = 0
            //println("Сбросился sum")
            for(k<- 0 to rows){
              sum = sum + (matrix(i)(k) * other.matrix(k)(j))
              //println("Сумма: " + sum)
            }
            matrix2(i)(j) = sum
            print(matrix2(i)(j) + " ")
          }
          print("\n")
        }
      } else println("Матрицы не могут быть перемножены!")
    }
    def *|(n: Int) ={ // Умножение на скаляр, не знаю как сделать иначе
      println("Умножение на скаляр: ")
      for(i <- 0 until rows){
        for(j<- 0 until columns){
          matrix(i)(j) *= n
          print(matrix(i)(j) + " ")
        }
        print("\n")
      }
    }
  }
  val mt = new Matrix(2, 3)
  val mt2 = new Matrix(3, 2)
  mt + mt2
  mt * mt2
  mt *| 2
}
