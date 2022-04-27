/**
 * Напишите пакет random с функциями nextInt(): Int, nextDouble():
 * Double и setSeed(seed: Int): Unit.
 * Для генерации случайных чисел используйте линейный конгруэнтный генератор
 * next = (previous × a + b) mod 2n, где a = 1664525, b = 1013904223 и n = 32, а начальное значение
 * previous определяется аргументом seed.
 */
package com
class random {
  var previous = 0
  val a = 1664525
  val b = 1013904223
  val n = 32
  def setSeed(seed: Int) : Unit = {
    previous = seed
  }
  def nextInt() : Int = ((previous * a) + b) % (2 * n)
  def nextDouble(): Double = ((previous * a) + b) % (2 * n)
}

object Exercise_3 extends App{
  val test = new com.random
  test.setSeed(6)
  println(test.nextInt(), test.nextDouble())
}