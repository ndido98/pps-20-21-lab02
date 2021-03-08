package lab

import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test

class FunctionsTests {

    import lab.Functions._

    @Test
    def testParityWithVal() = {
        testParity(parityVal)
    }

    @Test
    def testParityWithDef() = {
        testParity(parityDef)
    }

    def testParity(parity: Int => String) = {
        assertEquals("odd", parity(5))
        assertEquals("even", parity(10))
        assertEquals("odd", parity(-1))
        assertEquals("even", parity(0))
    }
}
