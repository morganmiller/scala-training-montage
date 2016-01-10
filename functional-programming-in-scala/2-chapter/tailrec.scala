/* should compile to while loop */
object RecFactorial {
  def factorial(n: Int): Int = {
    @annotation.tailrec
    def loop(n: Int, acc: Int): Int =
      if (n <= 0) acc
      else loop(n-1, n*acc)

    loop(n, 1)
  }

  def main =
    factorial(7)
}

/* using tailrec annotation should throw error */
object BadFactorial {
  def notFactorial(n: Int): Int = {
    def loop(n: Int, acc: Int): Int =
      @annotation.tailrec
      if (n <= 0) acc
      else 1 + loop(n-1, n*acc)

    loop(n, 1)
  }

  def main =
    notFactorial(7)
}
