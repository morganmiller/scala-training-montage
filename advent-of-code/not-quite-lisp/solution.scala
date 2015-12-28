import scala.io.Source

val directions = Source.fromFile("not-quite-lisp/input.txt").getLines.mkString

def countFloors(s: String, upOrDown: Char) = {
  s.count(c => c == upOrDown)
}

println(countFloors(directions, '(') - countFloors(directions, ')')) //280

//refactor this with a case statement bc scala cases are rad
def basementPosition(s: String, index: Int = 0, floor: Int = 0):Int = {
  if(floor == -1){
    index
  } else if(s(index) == '(') {
    basementPosition(s, index+1, floor+1)
  } else {
    basementPosition(s, index+1, floor-1)
  }
}

println(basementPosition(directions))
