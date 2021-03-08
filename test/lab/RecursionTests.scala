package lab

import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test

class RecursionTests {

    import lab.Recursion._

    @Test
    def testFibonacci() = {
        assertEquals(0, fibonacci(0))
        assertEquals(1, fibonacci(1))
        assertEquals(1, fibonacci(2))
        assertEquals(2, fibonacci(3))
        assertEquals(3, fibonacci(4))
        assertEquals(5, fibonacci(5))
        assertEquals(8, fibonacci(6))
    }
}
