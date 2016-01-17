sealed trait MyList[+A]
case object Nil extends MyList[Nothing]
case class Cons[+A](head: A, tail: MyList[A]) extends MyList[A]

object MyList {

  def sum(ints: MyList[Int]): Int = ints match {
    case Nil => 0
    case Cons(x,xs) => x + sum(xs)
  }

  def product(ds: MyList[Double]): Double = ds match {
    case Nil => 1.0
    case Cons(0.0, _) => 0.0
    case Cons(x,xs) => x * product(xs)
  }

  def apply[A](as: A*): MyList[A] =
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))

  def tail[A](ml: MyList[A]): MyList[A] = ml match {
    case Nil => Nil
    case Cons(_, t) => t
  }

  def setHead[A](ml: MyList[A], h: A): MyList[A] = ml match {
    case Nil => Cons(h, Nil)
    case Cons(_, t) => Cons(h, t)
  }

  def drop[A](ml: MyList[A], n: Int): MyList[A] = {
    if (n <= 0) ml
    else ml match {
      case Nil => Nil
      case Cons(_, t) => drop(t, n-1)
    }
  }

  // def dropWhile[A](ml: MyList[A], f: A => Boolean): MyList[A] = ml match {
  //   case Cons(h,t) if f(h) => dropWhile(t, f)
  //   case _ => ml
  // }

  //dropWhile with type inference on its 2nd argument
  def dropWhileInferred[A](ml: MyList[A])(f: A => Boolean): MyList[A] = ml match {
    case Cons(h,t) if f(h) => dropWhileInferred(t)(f) //note that it is now called as a curried function
    case _ => ml
  }
  //can be called like:
      // dropWhileInferred(List(1,2,5))(x => x < 4)

  def init[A](ml: MyList[A]): MyList[A] = ml match {
    case Nil => Nil
    case Cons(_, Nil) => Nil
    case Cons(h,t) => Cons(h, init(t))
  } // Not constant time, can reach stack overflow for large lists


  def foldRight[A,B](foo: MyList[A], z: B)(f: (A, B) => B): B = foo match {
    case Nil => z
    case Cons(x, xs) => f(x, foldRight(xs, z)(f))
  }

  // def length[A](ml: MyList[A]): Int = {
  //   foldRight(l, 0)((h, t) => t + 1)
  // }
}

// val list = MyList(1,2,3)
// MyList.tail(list) // = Cons(2,Cons(3,Nil))
//                           //In the Scala REPL, results are displayed with a call to the class's toString method
//                           //Which is why actual List class would show List(2,3)
// MyList.setHead(list, 5) // = Cons(5,Cons(2, Cons(3,Nil)))
// MyList.drop(list, 2) // = Cons(3,Nil)
//
// def shouldDrop[A](x: A): Boolean = {
//   x == x
// }
//
// MyList.dropWhile(list, shouldDrop) //Nil
