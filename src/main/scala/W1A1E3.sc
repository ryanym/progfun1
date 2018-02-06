def countChange(money: Int, coins: List[Int]): Int = {
  /*
  https://mitpress.mit.edu/sicp/full-text/book/book-Z-H-11.html#%_sec_1.2.2
  Therefore, the total number of ways to make change for some amount is equal to
  the number of ways to make change for the amount without using any of the first
  kind of coin, plus the number of ways to make change assuming that we do use the
  first kind of coin. But the latter number is equal to the number of ways to make
   change for the amount that remains after using a coin of the first kind.
   */
  if ( money == 0 ) 1
  else if (( money < 0) || coins.isEmpty) 0
  else countChange(money, coins.tail) + countChange(money - coins.head, coins)

}

countChange(10,List(1,2,5))





