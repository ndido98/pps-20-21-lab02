package lab

import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test

class OptionalsTests {

    import u02.Optionals._
    import u02.Optionals.Option._

    val s1: Option[Int] = Some(1)
    val s2: Option[Int] = Some(2)
    val s3: Option[Int] = None()

    @Test
    def testIsEmpty() = {
        assertFalse(isEmpty(s1))
        assertFalse(isEmpty(s2))
        assertTrue(isEmpty(s3))
    }

    @Test
    def testGetOrElse() = {
        assertEquals(1, getOrElse(s1, 0))
        assertEquals(2, getOrElse(s2, 0))
        assertEquals(0, getOrElse(s3, 0))
    }

    @Test
    def testFlatMap() = {
        assertEquals(Some(2), flatMap(s1)(i => Some(i + 1)))
        assertEquals(Some(3), flatMap(s1)(i => flatMap(s2)(j => Some(i + j))))
        assertEquals(None(), flatMap(s1)(i => flatMap(s3)(j => Some(i + j))))
    }

    @Test
    def testFilter() = {
        assertEquals(s1, filter(s1)(_ > 0))
        assertEquals(s2, filter(s2)(_ > 1))
        assertEquals(None(), filter(s3)(_ > 0))
        assertEquals(None(), filter(s1)(_ > 1))
    }

    @Test
    def testMap() = {
        assertEquals(Some(true), map(s1)(_ > 0))
        assertEquals(Some(4), map(s2)(_ * 2))
        assertEquals(None(), map(s3)(_ - 1))
    }

    @Test
    def testMap2() = {
        val sumMapper = (a: Int, b: Int) => a + b
        val equalsMapper = (a: Int, b: Int) => a == b
        assertEquals(Some(3), map2(s1, s2)(sumMapper))
        assertEquals(Some(false), map2(s1, s2)(equalsMapper))
        assertEquals(None(), map2(s1, s3)(sumMapper))
        assertEquals(None(), map2(s3, s2)(sumMapper))
        assertEquals(None(), map2(s3, s3)(sumMapper))
    }
}
