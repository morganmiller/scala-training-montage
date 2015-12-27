class Bob {
  def hey(statement: String) = {
    if (statement.toUpperCase() == statement && containsLetters(statement)) {
      "Whoa, chill out!"
    } else if(statement.takeRight(1) == "?")  {
      "Sure."
    } else if(statement.trim==""){
      "Fine. Be that way!"
    } else {
      "Whatever."
    }
  }

  val letters=(('A' to 'Z')).toSet
  def containsLetters(s:String)=s.exists(letters.contains(_))
}
