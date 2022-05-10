package cstruct

import java.io.IOException

// No difference between checked and unchecked exceptions

// Throw is an expression
fun percentage(number: Int) {
    val percentage =
        if (number in 0..100)
            number
        else
            throw IllegalArgumentException("A percentage value must be between 0 and 100: $number")
}

// Try is an expression
fun tryExpression() {
    val number = try {
        Integer.parseInt("not-good")
    } catch (e: NumberFormatException) {
        // Assign null if error
        null
    }
}

// If Java try/catch this method call, it won't compile, because Kotlin is wrapping checked exceptions, and it's not thrown/propagated
fun foo() {
    throw IOException()
}

// If Java try/catch this method call, it will compile, because Kotlin is now propagating this exception
@Throws(IOException::class)
fun bar() {
    throw IOException()
}