package lab

import scala.math.Pi

object Shapes {
    sealed trait Shape
    object Shape {
        case class Rectangle(width: Double, height: Double) extends Shape
        case class Circle(radius: Double) extends Shape

        def perimeter(shape: Shape): Double = shape match {
            case Rectangle(w, h) => 2 * (w + h)
            case Circle(r) => 2 * Pi * r
        }

        def area(shape: Shape): Double = shape match {
            case Rectangle(w, h) => w * h
            case Circle(r) => Pi * r * r
        }
    }
}
