package lab

object Functions {

    val parityVal: Int => String = {
        case n if n % 2 == 0 => "even"
        case _ => "odd"
    }

    def parityDef(n: Int) = n match {
        case n if n % 2 == 0 => "even"
        case _ => "odd"
    }

    val negVal: (String => Boolean) => (String => Boolean) = predicate => !predicate(_)

    def negDef(predicate: String => Boolean): String => Boolean = !predicate(_)
}
