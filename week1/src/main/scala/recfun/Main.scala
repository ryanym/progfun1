package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int ): Int =
      if ((c < 0) || (c > r)) 0
      else if (r == 0 ) 1
      else pascal(c-1, r-1) + pascal(c, r-1)


  /**
   * Exercise 2
   */

    def balance(chars: List[Char]): Boolean = {
      def countParentheses(restChars: List[Char], counter: Int): Int =
        // # of ")" can never be larger than # of "(" in a balanced parentheses string
        if ((restChars.isEmpty) || (counter == -1 )) counter
        else if (restChars.head.toString == "(") countParentheses(restChars.tail, counter + 1)
        else if (restChars.head.toString == ")") countParentheses(restChars.tail, counter - 1)
        else countParentheses(restChars.tail, counter)

        if (countParentheses(chars, 0) == 0 ) true
        else false
    }
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
      if ( money == 0 ) 1
      else if (( money < 0) || coins.isEmpty) 0
      else countChange(money, coins.tail) + countChange(money - coins.head, coins)
    }
  }
