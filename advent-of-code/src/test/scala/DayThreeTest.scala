import org.scalatest._

class DayThreeSpecs extends FlatSpec with Matchers {
  it should "calculate unique houses visited" in {
    val numberOfHouses = Navigator.housesSantaVisited("^>v<")
    numberOfHouses should be (4)
  }
}
