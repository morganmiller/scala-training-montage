object CheckOrder {
  def isSorted[A](ar: Array[A], c: (A,A) => Boolean): Boolean = {
    def go(n: Int): Boolean =
      if(n >= ar.length-1) true
      else if(c(ar(n), ar(n+1))) go(n+1)
      else false

    go(0)
  }

  def isLessThan(a: Int, b: Int): Boolean =
    a < b

  def main = {
    val arr = Array(1,2,3,4,5)
    val unsortedArr = Array(5,4,2,1,3)
    println(isSorted(arr, isLessThan)) // prints true
    println(isSorted(unsortedArr, isLessThan)) // prints false
  }
}

CheckOrder.main
