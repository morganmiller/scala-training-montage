import scala.io.Source

class PaperCalculator(dimensionsFilename: String) {
  def orderAmount = {
    val surfaceAreas = getDimensions.map(dimensions => surfaceArea(dimensions) + extraPaper(dimensions))
    surfaceAreas.reduce(_+_)
  }

  def getDimensions = {
    val roughDimensions = Source.fromFile(dimensionsFilename).getLines.toList
    roughDimensions.map(lwh => lwh.split('x').toList.map(x => x.toInt))
  }

  def surfaceArea(dimensions: List[Int]) = {
    val multipliers = dimensions.drop(1)++dimensions.take(1)
    val products = dimensions.zip(multipliers).map({case (x,y) => x*y})
    products.reduce(_+_) * 2
  }

  def extraPaper(dimensions: List[Int]) = {
    dimensions.sortWith(_>_).drop(1).reduce(_*_)
  }
}
