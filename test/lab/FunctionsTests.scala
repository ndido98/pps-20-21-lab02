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

    @Test
    def testBetweenValWithCurrying() = {
        testBetweenWithCurrying(p1)
    }

    @Test
    def testBetweenDefWithCurrying() = {
        testBetweenWithCurrying(p3)
    }

    @Test
    def testBetweenValWithoutCurrying() = {
        testBetweenWithoutCurrying(p2)
    }

    @Test
    def testBetweenDefWithoutCurrying() = {
        testBetweenWithoutCurrying(p4)
    }

    @Test
    def testCompose() = {
        assertEquals(9, compose((_: Int) - 1, (_: Int) * 2)(5))
        assertEquals("testgf", compose((_: String) + "f", (_: String) + "g")("test"))
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

    def testBetweenWithCurrying(f: Int => Int => Int => Boolean) = {
        assertTrue(f(1)(2)(3))
        assertFalse(f(1)(3)(2))
        assertFalse(f(2)(1)(3))
        assertFalse(f(2)(3)(1))
        assertFalse(f(3)(1)(2))
        assertFalse(f(3)(2)(1))
    }

    def testBetweenWithoutCurrying(f: (Int, Int, Int) => Boolean) = {
        assertTrue(f(1, 2, 3))
        assertFalse(f(1, 3, 2))
        assertFalse(f(2, 1, 3))
        assertFalse(f(2, 3, 1))
        assertFalse(f(3, 1, 2))
        assertFalse(f(3, 2, 1))
    }
}
