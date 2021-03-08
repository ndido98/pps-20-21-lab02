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
}
