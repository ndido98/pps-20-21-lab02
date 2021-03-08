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
        val mapped = flatMap(s1)(i => Some(i + 1))
        assertFalse(isEmpty(mapped))
        assertEquals(2, getOrElse(mapped, 0))
    }
}
