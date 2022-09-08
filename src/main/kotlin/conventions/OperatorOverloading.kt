package conventions

import java.awt.Point

// Arithmetic operations

// operator modifier allows us this, list of possible operations:
// plus +
// minus -
// times *
// div /
// mod %
operator fun Point.plus(other: Point): Point {
    // a + b -----> a.plus(b)
    return Point(x + other.x, y + other.y)
}

// You can also do something like this, with different type:
operator fun Point.times(scale: Int): Point {
    return Point(x * scale, y * scale)
}

// Unary operations
// -a -----> a.unaryMinus()
// Possible options:
// +a unaryPlus
// -a unaryMinus
// !a not
// ++a a++ inc
// --a a-- dec
operator fun Point.unaryMinus() = Point(-x, -y)

// Assignment operations
// a+= -----> a = a.plus(b)
// a+= -----> a.plusAssign(b)

fun main() {
    val point = Point(1, 2) + Point(4, 5)
    val scaled = Point(4, 5) * 3

    val negativePoint = -Point(5, 6)

    // Convention for lists
    val list = listOf(1, 2, 3)
    val newList = list + 2
    println(newList)
    val mutableList = mutableListOf(1, 2, 3)
    mutableList += 4
    println(mutableList)
}