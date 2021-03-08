package u02

object Optionals {

    sealed trait Option[A] // An Optional data type
    object Option {

        case class None[A]() extends Option[A]

        case class Some[A](a: A) extends Option[A]

        def isEmpty[A](opt: Option[A]): Boolean = opt match {
            case None() => true
            case _ => false
        }

        def getOrElse[A, B >: A](opt: Option[A], orElse: B): B = opt match {
            case Some(a) => a
            case _ => orElse
        }

        def flatMap[A, B](opt: Option[A])(f: A => Option[B]): Option[B] = opt match {
            case Some(a) => f(a)
            case _ => None()
        }

        def filter[A](opt: Option[A], predicate: A => Boolean): Option[A] = opt match {
            case Some(a) if predicate(a) => opt
            case _ => None()
        }

        def map[A, B](opt: Option[A], mapper: A => B): Option[B] = opt match {
            case Some(a) => Some(mapper(a))
            case None() => None()
        }

        def map2[A, B, C](optA: Option[A], optB: Option[B], mapper: (A, B) => C): Option[C] = (optA, optB) match {
            case (Some(a), Some(b)) => Some(mapper(a, b))
            case _ => None()
        }
    }
}
