import scala.io.Source

class OrderCalculator(dimensionsFilename: String) {
  def getDimensions = {
    val roughDimensions = Source.fromFile(dimensionsFilename).getLines.toList
    roughDimensions.map(lwh => lwh.split('x').toList.map(x => x.toInt))
  }

  def paperAmount = {
    val paperAmounts = getDimensions.map(dimensions => new Present(dimensions).wrappingPaper)
    paperAmounts.reduce(_+_).toString + " feet"
  }

  def ribbonAmount = {
    val ribbonAmounts = getDimensions.map(dimensions => new Present(dimensions).ribbonLength)
    ribbonAmounts.reduce(_+_).toString + " feet"
  }
}

class Present(dimensions: List[Int]) {

  def wrappingPaper = {
    surfaceArea + extraPaper
  }

  def ribbonLength = {
    ribbonForBow + ribbonToWrap
  }

  def surfaceArea = {
    val multipliers = dimensions.drop(1)++dimensions.take(1)
    val products = dimensions.zip(multipliers).map({case (x,y) => x*y})
    products.reduce(_+_) * 2
  }

  def smallestSides = {
    dimensions.sortWith(_>_).drop(1)
  }

  def extraPaper = {
    smallestSides.reduce(_*_)
  }

  def ribbonForBow = {
    dimensions.reduce(_*_)
  }

  def ribbonToWrap = {
    smallestSides.reduce(_+_) * 2
  }
}
