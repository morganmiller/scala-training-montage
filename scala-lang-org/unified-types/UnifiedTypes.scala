object UnifiedTypes extends App {
  val set = new scala.collection.mutable.LinkedHashSet[Any]
  set += "a string"
  set += 732
  set += 'c'
  set += true
  set += main _
  val iter: Iterator[Any] = set.iterator
  val callme = while(iter.hasNext) {
    println(iter.next.toString())
  }
}

println(UnifiedTypes.set)
