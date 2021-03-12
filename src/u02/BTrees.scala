package u02

object BTrees {

    // A custom and generic binary tree of elements of type A
    sealed trait Tree[A]

    object Tree {

        case class Leaf[A](value: A) extends Tree[A]

        case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]

        def size[A](t: Tree[A]): Int =
            mapReduce(t, (e: A) => 1, (_: Int) + (_: Int))

        def find[A](t: Tree[A], elem: A): Boolean =
            mapReduce(t, (e: A) => e == elem, (_: Boolean) || (_: Boolean))

        def count[A](t: Tree[A], elem: A): Int =
            mapReduce(t, (e: A) => if (e == elem) 1 else 0, (_: Int) + (_: Int))

        def mapReduce[A, R](t: Tree[A], mapper: A => R, reduceOperator: (R, R) => R): R = t match {
            case Branch(l, r) => reduceOperator(
                mapReduce(l, mapper, reduceOperator),
                mapReduce(r, mapper, reduceOperator)
            )
            case Leaf(e) => mapper(e)
        }
    }
}
