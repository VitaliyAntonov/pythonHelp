object Gramm{
    // Грамматика - набор правил составленя строк.
    /**
     * Правила:
     * Каждое число целиком является арифметическим выражением
     * +-* являются операторами
     * если left и right аримефтические выражения, а op - оператор, тогда left op right является арифметическим выражением
     * если expr - арифметическое выражение, тогда (expr) является арифметическим выражением
     */
    //Грамматика обычно записывается в нотации, называемые формой Бэкуса-Нуара
    // Пример:
    //op ::= "+"| "-" | "*"
    //expr ::= number | expr op expr | "(" expr ")"
    //digit ::= "0" | "1" | "2" | "3" | "4" | "5" | "6" | "7" | "8" | "9"
    //number ::= digit | digit number
    //Список чисел, разделенных запятыми, в грамматике можно описать так:
    //numberList ::= number ( "," numberList )?
  }
  object CombOpPars{
    //Чтобы задействовать библиотеку парсинга в языке Scala, необходимо реализовать класс, наследующий трейт Parsers и определяющий операции парсинга
    import scala.util.parsing.combinator._
    class ExprParser extends RegexParsers {
      val number = "[0-9]+".r
      def expr: Parser[Any] = term ~ opt(("+" | "-") ~ expr)
      def term: Parser[Any] = factor ~ rep("*" ~ factor)
      def factor: Parser[Any] = number | "(" ~ expr ~ ")"
      //Для объединения частей выражения используется оператор ~,
      //а вместо ? и * используются opt и rep
    }
    val parser = new ExprParser
    val result = parser.parseAll(parser.expr, "3-4*5")
    if(result.successful) println(result.get)
    // Получится ((3~List())~Some((-~((4~List((*~5)))~None))))
  }

object TrResPar{ // Преобразование результатов парсинга
  import scala.util.parsing.combinator._
  class ExprParser extends RegexParsers {
    val number = "[0-9]+".r
    def expr: Parser[Int] = term ~ opt(("+" | "-") ~ expr) ^^ {
        case t ~ None => t
        case t ~ Some("+" ~ e) => t + e
        case t ~ Some("-" ~ e) => t - e
    }
    def term: Parser[Int] = factor ~ rep("*" ~ factor) ^^ {
      case f ~ r => f * r.map(_._2).product
    }
    def factor: Parser[Int] = number ^^ {_.toInt} | "(" ~ expr ~ ")" ^^{
      case _ ~ e ~ _ => e
    }
  }
  val parser = new ExprParser
  val result = parser.parseAll(parser.expr, "3-4*5")
  if(result.successful) println(result.get)
}

object OtLex{ // Отбрасывание лексем
  import scala.util.parsing.combinator._
  /**
   * Для сопоставления и удаления лексем используются операторы ~> и <~. Например, результатом выражения
   * "*" ~> factor будет результирующий factor, а не значение в форме "*" ~ f.
   * Операторы «подсказывающих стрелок», ~> и <~, указывают на часть, которая остается.
   */
  class ExprParser extends RegexParsers {
    val number = "[0-9]+".r
    def expr: Parser[Int] = term ~ opt(("+" | "-") ~ expr) ^^ {
      case t ~ None => t
      case t ~ Some("+" ~ e) => t + e
      case t ~ Some("-" ~ e) => t - e
    }
    def term: Parser[Int] = factor ~ rep("*" ~> factor) ^^ {
      case f ~ r => f * r.product
    }
    def factor: Parser[Int] = number ^^ {_.toInt} | "(" ~> expr <~ ")"
  }
  val parser = new ExprParser
  val result = parser.parseAll(parser.expr, "3-4*5")
  if(result.successful) println(result.get)
}

object SyntaxTree{ // Создание деревьев синтаксического анализа
  // При разработке интерпретатора или компилятора вместо вычисления выражения требуется сконструировать дерево синтаксического анализа.
  // Делается это обычно с помощью case-классов.
  import scala.util.parsing.combinator._
  class Expr
  case class Number(value: Int) extends Expr
  case class Operator(op: String, left: Expr, right: Expr) extends Expr
  // Задача парсера состоит в том, чтобы преобразовать исходное выражение, такое как 3+4*5, в значение
  //Operator("+", Number(3), Operator("*", Number(4), Number(5))).
  // Для создания дерева синтаксического анализа используется оператор ^^ с функциями, возвращающими узлы дерева.
  abstract class ExprParser extends RegexParsers {
    def term: Parser[Expr] = (factor ~ opt("*" ~> term)) ^^ {
      case a ~ None => a
      case a ~ Some(b) => Operator("*", a, b)
    }
    def factor: Parser[Expr]
  }
}

object LeftRecursive{ // Уход от левой рекурсии
  //Если функция парсера, вызывающая сама себя, не поглощает некоторую часть входного текста,
  // есть риск, что рекурсия никогда не прекратится.
  // Рассмотрим функцию, которая, как предполагается, поглощает произвольную последовательность единиц:
  // def ones: Parser[Any] = ones ~ "1" | "1"
  // Такие функции называются леворекурсивными (left-recursive).
  // Чтобы избежать рекурсии, можно переформулировать грамматику.
  // def ones: Parser[Any] = "1" ~ ones | "1" или def ones: Parser[Any] = rep1("1")
  import scala.util.parsing.combinator._
  class ExprParser extends RegexParsers {
    val number = "[0-9]+".r
    def expr: Parser[Int] = term ~ rep(
      ("+" | "-") ~ term ^^ {
        case "+" ~ t => t
        case "-" ~ t => -t
      }) ^^ { case t ~ r => t + r.sum }
    def term: Parser[Int] = factor ~ rep("*" ~> factor) ^^ {
      case f ~ r => f * r.product
    }
    def factor: Parser[Int] = number ^^ {_.toInt} | "(" ~> expr <~ ")"
  }
  val parser = new ExprParser
  val result = parser.parseAll(parser.expr, "3-4*5")
  if(result.successful) println(result.get)

}
