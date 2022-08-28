package basics

fun max1(a: Int, b: Int): Int {
    return if (a > b) a else b
}

// Function with expression body
fun max2(a: Int, b: Int): Int = if (a > b) a else b

// Implicitly returns : Unit (like void)
fun displayMax(a: Int, b: Int) {
    println(max1(a, b))
}

// Top-level function
fun topLevel() = 1

class A {
    // Member function
    fun member() = 2
}

fun other() {
    // Local function
    fun local() = 3
}

// Default values
fun displaySeparator(character: Char = '*', size: Int = 10) {
    repeat(size) {
        print(character)
    }
}

fun sum1(a: Int = 0, b: Int = 0, c: Int = 0) = a + b + c

// From Kotlin, we have 2^3 = 8 variations, from Java only 4 overloads (see FunctionsJ.java)
@JvmOverloads
fun sum2(a: Int = 0, b: Int = 0, c: Int = 0) = a + b + c

fun main() {
    // Named arguments
    println(listOf('a', 'b', 'c').joinToString(separator = "", prefix = "(", postfix = ")"))
    // Default argument for 'separator' is ', '
    println(listOf('a', 'b', 'c').joinToString(prefix = "(", postfix = ")"))

    displaySeparator()
    println()
    displaySeparator('-')
    println()
    // Here we have to specify named arg for 2nd param
    displaySeparator(size = 5)
    println()
    displaySeparator('#', 3)
    // Won't compile
    //displaySeparator(3, '$')
    println()
    // Specifying named args, we can change order
    displaySeparator(size = 3, character = '$')

    // Java solution - overloads
}