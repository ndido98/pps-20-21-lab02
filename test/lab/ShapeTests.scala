package lab

import scala.math.Pi
import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test

class ShapeTests {

    import Shapes.Shape._

    val Epsilon = 0.0001
    val rect = Rectangle(2.0, 4.0)
    val circle = Circle(4.0)

    @Test
    def testPerimeter() = {
        assertEquals(12.0, perimeter(rect), Epsilon)
        assertEquals(2 * Pi * 4.0, perimeter(circle), Epsilon)
    }

    @Test
    def testArea() = {
        assertEquals(8.0, area(rect), Epsilon)
        assertEquals(Pi * 4.0 * 4.0, area(circle), Epsilon)
    }
}
