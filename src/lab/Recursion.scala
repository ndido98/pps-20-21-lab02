package lab

import scala.annotation.tailrec

object Recursion {

    def fibonacci(n: Int): Int = {
        @tailrec
        def _inner(n: Int, a: Int, b: Int): Int = n match {
            case 0 => a
            case _ => _inner(n - 1, b, a + b)
        }
        _inner(n, 0, 1)
    }
}
