/**
 * Добавьте метод allDifferent в объект, скомпилируйте и загляните в байт-код.
 * Какие методы будут сгенерированы после применения аннотации @specialized?
 */
object Exercise_8 extends App{
  def allDifferent[@specialized T](x: T, y: T, z: T) = x != y && x != z && y != z
  println(allDifferent(1, 2, 3))
}

