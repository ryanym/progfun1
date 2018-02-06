def balance(chars: List[Char]): Boolean = {
  def countParentheses(restChars: List[Char], counter: Int): Int =
    // # of ")" can never be larger than # of "(" in a balanced parentheses string
    if ((restChars.isEmpty) || (counter == -1 )) counter
    else if (restChars.head.toString == "(") countParentheses(restChars.tail, counter + 1)
    else if (restChars.head.toString == ")") countParentheses(restChars.tail, counter - 1)
    else countParentheses(restChars.tail, counter)

  if (countParentheses(chars, 7) == 0 ) true
  else false
}

val s = "(if (zero? x) max (/ 1 x))"
val l = s.toList

val l2 = "(if (zero? x) max (/ 1 x))())(".toList

balance(l2)


