import org.scalatest._

class DayTwoSpecs extends FlatSpec with Matchers {
//OrderCalculator tests
  def calculator = new OrderCalculator("src/test/input/presentdimensions.txt")

  it should "format the dimensions of many presents" in {
    val presentDimensions = calculator.getDimensions
    presentDimensions should be(List(List(1, 2, 3), List(2, 3, 4)))
  }

  it should "calculate the total paper needed from a text file of present dimensions" in {
    val allThePaper = calculator.paperAmount
    allThePaper should be ("82 feet")
  }

  it should "calculate the total ribbon needed for all presents" in {
    val allTheRibbon = calculator.ribbonAmount
    allTheRibbon should be("46 feet")
  }

//Present tests
  def present = new Present(List(2,3,4))

  it should "find the surface area of one present" in {
    val result = present.surfaceArea
    result should be (52)
  }

  it should "find the extra paper needed for one present" in {
    val result = present.extraPaper
    result should be (6)
  }

  it should "find the ribbon needed to wrap the smallest perimeter" in {
    val result = present.ribbonToWrap
    result should be (10)
  }

  it should "calculate its volume to find ribbon needed for bow" in {
    val result = present.ribbonForBow
    result should be (24)
  }

  it should "calculate the total amount of ribbon needed for wrapping" in {
    val result = present.ribbonLength
    result should be (34)
  }
}
