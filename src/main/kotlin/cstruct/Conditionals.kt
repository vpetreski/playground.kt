package cstruct

import cstruct.Color.*

fun max(a: Int, b: Int) {
    // if is an expression
    val max = if (a > b) a else b
    // No ternary operator
    //val max = (a > b) ? a : b
}

enum class Color {
    BLUE, ORANGE, RED, YELLOW, VIOLET, GREEN, INDIGO
}

fun getDescription(color: Color): String =
    // expression; no break & default
    when (color) {
        BLUE -> "cold"
        ORANGE -> "mild"
        else -> "hot"
    }

// Check several values at once
fun respondToInput(input: String): String = when (input) {
    "y", "yes" -> "Glad you agree"
    "n", "no" -> "Sorry to hear that"
    else -> "I don't understand you"
}

// Return type inference
// Any expression can be used as a branch condition
fun mix(c1: Color, c2: Color) =
    // The argument is checked for equality with the branch conditions
    when (setOf(c1, c2)) {
        setOf(RED, YELLOW) -> ORANGE
        setOf(YELLOW, BLUE) -> GREEN
        setOf(BLUE, VIOLET) -> INDIGO
        else -> throw Exception("Dirty color")
    }

open class Pet

class Cat : Pet() {
    fun meow(): String {
        return "meow"
    }
}

class Dog : Pet() {
    fun woof(): String {
        return "woof"
    }
}

fun getPet(): Pet {
    return Cat()
}

// is (in Java instanceof)
fun getSound(pet: Pet): String =
    /*when (pet) {
        // Smart cast
        is Cat -> pet.meow()
        is Dog -> pet.woof()
        else -> "---"
    }*/
    // Capturing when subject in a variable
    when (val p = getPet()) {
        is Cat -> p.meow()
        is Dog -> p.woof()
        else -> "---"
    }

// when without argument
fun updateWeather(degrees: Int) {
    val color = when {
        // Any boolean condition
        degrees < 5 -> BLUE
        degrees < 23 -> ORANGE
        else -> RED
    }
}