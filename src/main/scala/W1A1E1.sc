def pascal(c: Int, r: Int ): Int =

  if ((c < 0) || (c > r)) 0
  else if (r == 0 ) 1
  else pascal(c-1, r-1) + pascal(c, r-1)

pascal(2,2)

