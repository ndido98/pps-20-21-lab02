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

    val p1: Int => Int => Int => Boolean = x => y => z => (x <= y && y <= z)

    val p2: (Int, Int, Int) => Boolean = (x, y, z) => (x <= y && y <= z)

    def p3(x: Int)(y: Int)(z: Int): Boolean = x <= y && y <= z

    def p4(x: Int, y: Int, z: Int): Boolean = x <= y && y <= z

    def compose[A, B, C](f: B => C, g: A => B): A => C = x => f(g(x))
}
