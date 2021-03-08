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
        testParity(parity)
    }

    @Test
    def testNegWithVal() = {
        testNeg(negVal)
    }

    @Test
    def testNegWithDef() = {
        testNeg(neg)
    }

    @Test
    def testGenericNeg() = {
        val zero = (n: Int) => n == 0
        val nonZero = neg(zero)
        assertTrue(zero(0))
        assertFalse(zero(10))
        assertTrue(nonZero(10))
        assertFalse(nonZero(0))
    }

    def testParity(parity: Int => String) = {
        assertEquals("odd", parity(5))
        assertEquals("even", parity(10))
        assertEquals("odd", parity(-1))
        assertEquals("even", parity(0))
    }

    def testNeg(neg: (String => Boolean) => (String => Boolean)) = {
        val empty = (s: String) => s == ""
        val notEmpty = neg(empty)
        assertTrue(empty(""))
        assertFalse(empty("test"))
        assertTrue(notEmpty("test"))
        assertFalse(notEmpty(""))
    }
}
