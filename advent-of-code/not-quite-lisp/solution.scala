import scala.io.Source

val directions = Source.fromFile("input.txt").getLines.mkString

def countFloors(s: String, upOrDown: Char) = {
  s.count(c => c == upOrDown)
}

println(countFloors(directions, '(') - countFloors(directions, ')')) //280
