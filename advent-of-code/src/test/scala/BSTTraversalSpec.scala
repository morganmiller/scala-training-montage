import org.scalatest._

class BSTTraversalSpec extends FlatSpec with Matchers {

  it should "return true" in {
    assert(BSTTraversal.isPreorderTraversal(List(1, 2, 3)))
    assert(BSTTraversal.isPreorderTraversal(List(3,2,1,5,4,6)))
  }

  it should "return false" in {
    assert(!BSTTraversal.isPreorderTraversal(List(1,3,4,2)))
    assert(!BSTTraversal.isPreorderTraversal(List(3,4,5,1,2)))
  }
}
