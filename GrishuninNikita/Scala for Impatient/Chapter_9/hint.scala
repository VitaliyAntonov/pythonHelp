//Exercise_6
// -?[0-9]+([.]?[0-9]+)?
//  -       - начинается со знака "-"
//    ?       - которого может и не быть
//  [0-9]   - продолжается цифрами 0 - 9
//    +       - которые могут встречаться от одного раза и более
// (        - далее следуют группа...
//      [.]     - далее следует точка
//        ?       - которой может и не быть
//      [0-9]   - и цифры 0-9
//        +     - которые могут встречаться от одного раза и более
//  )?      - ... заканчивается группа, которой может и не быть
//Exercise_7
// "([^\\"]|\\\\|\\")*"
// "            - начинается с кавычки
// (            - посредине вот эта группа...
//    [^\\"]        - внутри группы не может содержаться \ или "
//    |
//    \\\\          - может содержаться \\
//    |
//    \\"           - может содержаться \"
// )*           - повторяется сколько угодно раз
// "            - заканчивается кавычкой
//Exercise_8
// <img.*\ssrc\s*=\s*"(.+)"
//  <img      - начинается с img
//  .*        - далее любойсимвол от 0 и более раз
//  \s        - далее какой-нибудь пробельный символ
//  src       - затем src
//  \s*       - далее какой-нибудь пробельный символ от 0 и более раз
//  =         - равно
//  \s*       - далее какой-нибудь пробельный символ от 0 и более раз
//  "         - кавычка
// (.+)       - подвыражение, содержащее от 1 и более любых символов
// "          - заканчивается "