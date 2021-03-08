package lab

object Functions {

    val parityVal: Int => String = {
        case n if n % 2 == 0 => "even"
        case _ => "odd"
    }

    def parity(n: Int) = n match {
        case n if n % 2 == 0 => "even"
        case _ => "odd"
    }

    val negVal: (String => Boolean) => (String => Boolean) = predicate => !predicate(_)

    def neg[P](predicate: P => Boolean): P => Boolean = !predicate(_)
}
