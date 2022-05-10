package extensions

// Extending the class outside the class
// String is the "receiver" here, receiving the function lastChar
// We can access the receiver with "this" when needed, but we can also omit when possible (length)
// We can't call private methods of the receiver inside our function
fun String.lastChar() = this[length - 1]

// If we want to use this extension elsewhere, we have to import it
//import extensions.lastChar
//import extensions.*

// From Java we would call it like regular static function:
// ExtensionFunctionsKt.lastChar("kotlin")
// So, Kotlin extension functions are regular static functions defined in a separate auxiliary class

fun main() {
    println("kotlin".lastChar()) // n
}