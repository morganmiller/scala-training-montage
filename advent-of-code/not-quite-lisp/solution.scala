import scala.io.Source

val directions = Source.fromFile("not-quite-lisp/input.txt").getLines.mkString

//What floor does Santa end up on? Round One
def countFloors(s: String, upOrDown: Char) = {
  s.count(c => c == upOrDown)
}

println(countFloors(directions, '(') - countFloors(directions, ')')) //280

//When does he make his first trip to the basement? Round Two: if/else way
def basementPosition(s: String, index: Int = 0, floor: Int = 0):Int = {
  if(floor == -1){
    index
  } else if(s(index) == '(') {
    basementPosition(s, index+1, floor+1)
  } else {
    basementPosition(s, index+1, floor-1)
  }
}

println(basementPosition(directions)) //1797

//Round Two: the neat scala-esque pattern matching way
def basementPositionTwo(s: String, index: Int = 0, floor: Int = 0):Int = floor match {
  case -1 => index
  case _ => s(index) match {
    case '(' => basementPositionTwo(s, index+1, floor+1)
    case ')' => basementPositionTwo(s, index+1, floor-1)
  }
}

println(basementPositionTwo(directions)) //1797

//Can Round Two be done with PartialFunction and orElse?
