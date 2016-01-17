object Parser {
  def parseInput() = {
    val numberOfTests = readInt
    0.until(numberOfTests).map(
      testNumber => {
        readInt
        val numbers = readLine
        numbers.split(" ").toList.map(_.toInt)
      }
    )
  }
}

object BSTTraversal {
  def isPreorderTraversal(l: List[Int]): Boolean = l match {
    case Nil => true
    case root :: rest => {
      val (leftTree, rightTree) = rest.span(_<root)
      if (!rightTree.forall(_ > root)) return false
      isPreorderTraversal(leftTree) && isPreorderTraversal(rightTree)
    }
  }
}

object Output {
  def print(result: Boolean) = result match {
    case true => println("YES")
    case false => println("NO")
  }
}

Parser.parseInput().map(BSTTraversal.isPreorderTraversal).foreach(Output.print)
