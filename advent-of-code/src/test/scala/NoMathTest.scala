import org.scalatest._

class NoMathSpecs extends FlatSpec with Matchers {
  def calculator = new PaperCalculator("src/test/input/presentdimensions.txt")

  it should "format the dimensions of many presents" in {
    val presentDimensions = calculator.getDimensions
    presentDimensions should be(List(List(1, 2, 3), List(2, 3, 4)))
    /** When this was: (List(Array(1,2,3), Array(2,3,4))),
    Failed: List(Array(1, 2, 3), Array(2, 3, 4)) was not equal to List(Array(1, 2, 3), Array(2, 3, 4))
    Wtf? Array/List behavior different? */
  }

  it should "find the surface area of one present" in {
    val result = calculator.surfaceArea(List(2,3,4))
    result should be (52)
  }

  it should "find the extra paper needed for one present" in {
    val result = calculator.extraPaper(List(2,3,4))
    result should be (6)
  }

  it should "calculate the total paper needed from a text file of present dimensions" in {
    val allThePaper = calculator.orderAmount
    allThePaper should be (82)
  }
}
