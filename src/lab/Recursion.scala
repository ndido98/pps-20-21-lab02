package lab

object Recursion {

    // Not tail-recursive, if we added @tailrec the compiler would throw an error
    def fibonacci(n: Int): Int = n match {
        case 0 => 0
        case 1 => 1
        case n => fibonacci(n - 1) + fibonacci(n - 2)
    }
}
