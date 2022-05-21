/**
 * Взгляните на следующий псевдоним типа: type NetworkMember = n.Member forSome { val n: Network }
 * и на функцию: def process(m1: NetworkMember, m2: NetworkMember) = (m1, m2)
 * Назовите отличия от функции process из раздела 19.8 «Экзестенциальные типы».
 */
object Exercise_5 extends App{
  type NetworkMember
  def process1[M <: NetworkMember](m1: M, m2: M) = (m1, m2)
  def process2(m1: NetworkMember, m2: NetworkMember) = (m1, m2)
}
