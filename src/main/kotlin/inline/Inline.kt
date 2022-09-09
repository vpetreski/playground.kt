package inline

// Regular non-inlined lambdas
fun myRun(f: () -> Unit) = f()

// But when you inline the function, compiler substitutes a body of the function instead of calling it
inline fun <R> myRun2(block: () -> R): R = block()

fun main() {
    // Regular non-inlined lambdas
    val name = "Kotlin"
    // This brings performance overhead
    myRun { println("Hi, $name!") }
    // In comparison to:
    println("Hi, $name!")
    // ^ Because under the hood lambda will cause creation of a new class and objects in Java

    // But when you inline the function, compiler substitutes a body of the function instead of calling it
    myRun2 { println("Hi, $name!") }
    // So here ^ compiler will just generate inlined code of lambda body, so no performance overhead at all:
    // val name = "Kotlin"
    // println("Hi, $name!")

    // Use inline with care, most likely you won't have to use them at all, it's more about optimisation in special cases
}