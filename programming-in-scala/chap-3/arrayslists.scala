/** this creates a mutable collection, Array[String](3) */
val numNames = Array("zero", "one", "two")

/** this creates an immutable collection */
val myList = List("a", "b", "c")

/** list concatenation: */
val myOtherList = List("1","2","3")

val mySuperList = myList ::: myOtherList
println(mySuperList)

/** Array[Any] can contain elements of any mixed data type */

/** A Ruby Array has methods like push, pop, etc. that transform the original Array
But appending and removing information from a collection in Scala will return a brand new collection */

/** 'Cons' for appending to a list (and returning new list)
  To note: Since method ends in colon, method is invoked on right operand.
 */
val newList = "z" :: myList
println("myList is still the same: " + myList)
println("newList is a new list: " + newList)

val oneTwoThree = 1 :: 2 :: 3 :: Nil
val oneTwoThreeAgain = List(1,2,3)
println(oneTwoThree + " is identical to " + oneTwoThreeAgain)

/** More List Methods */
println("An empty list: " + List())
println("Nil is also an empty list: " + Nil)
val yay = List("cool", "tools", "rule")
println("YAY at index 2: " + yay(2))
val fourCount = yay.count(s => s.length == 4)
println("# of yay's 4-letter words: " + fourCount) /**expect 2*/
val fourWords = yay.filter(s => s.length == 4)
val notFourWords = yay.filterNot(s => s.length == 4) /** .remove gone with 2.9 */
println("Four-letter words in yay: " + fourWords)
println("And the rest: " + notFourWords)
println("Expect 'rule': " + yay.drop(2))
println("Expect 'cool': " + yay.dropRight(2))

// forAll and forEach not in 2.9. Research replacements...
// val checkLEnd = yay.forAll(s => s.endsWith("l"))
// println("Yup, it's " + checkLEnd)
//
// val whatsInYay = yay.forEach(s => print(s))
// val whatsInYayAgain = yay.forEach(print) /**concise, like &: in ruby */
// println(whatsInYay + " and " + whatsInYayAgain)
//
println(yay.head) /** like .first */
//
println(yay.mkString(" "))
