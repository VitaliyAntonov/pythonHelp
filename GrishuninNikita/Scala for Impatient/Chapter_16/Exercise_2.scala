/**
 * Каков будет результат следующего выражения
 *   val xml = <ul>
    <li>Opening bracket: [</li>
    <li>Closing bracket: ]</li>
    <li>Opening brace: {</li>
    <li>Closing brace: }</li>
    </ul>
 * in XML literal: in XML content, please use '}}' to express '}' <li>Closing brace: }</li>
 * Как его исправить?
 */

object Exercise_2 extends App{
  val xml = <ul>
    <li>Opening bracket: [</li>
    <li>Closing bracket: ]</li>
    <li>Opening brace: {{</li>
    <li>Closing brace: }}</li>
    </ul>
  println(xml)
}