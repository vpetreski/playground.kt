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