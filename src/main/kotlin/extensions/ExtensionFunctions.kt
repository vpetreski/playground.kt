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

fun main(args: Array<String>) {
    println("kotlin".lastChar()) // n

    // Examples from the Standard Library
    // Kotlin Standard Library = Java Standard Library + Extensions
    // No Kotlin SDK, just JDK + extensions => small runtime jar and easy Java interop

    // Standard collections
    val set = hashSetOf(1, 7, 53)
    val list = listOf(1, 7, 53)
    val map = hashMapOf(1 to "one", 2 to "two", 3 to "three")
    // javaClass property is the same as .getClass() in Java
    println(set.javaClass) // class java.util.HashSet
    println(list.javaClass) // class java.util.Arrays$ArrayList
    println(map.javaClass) // class java.util.HashMap
    // So, standard Java collections are being used under the hood, but Kotlin library provides extensions on collections:
    // list.max...
    // list.filter...
    // list.map...
    // list.reduce...
    // find, count, any, groupBy, etc...

    // Iterable extension function: joinToString
    println(listOf('a', 'b', 'c').joinToString(separator = "", prefix = "(", postfix = ")"))

    // Array extension function: getOrNull
    println("Hello, ${args.getOrNull(0)}!")

    // List extension function: getOrNull
    val lst = listOf("abc")
    println(lst.getOrNull(0)) // abc
    println(lst.getOrNull(1)) // null

    // Iterable extension function: withIndex()
    for ((index, element) in list.withIndex()) {
        println("$index $element")
    }

    // Extensions are very powerful, they give is nice syntactic features for standard Java types

    // Int extension function: until
    1.until(10)
    // infix variation - so it's not a build-in keyword, just normal extension function called with infix form
    1 until 10

    // Extension function: to
    // infix fun <A, B> A.to(that: B): Pair<A, B> = Pair(this, that)
    "answer".to(42)
    // infix form
    "answer" to 42
    // Reason for calling it "to" - convenient with maps:
    mapOf(0 to "zero", 1 to "one")
    // Same as
    mapOf(Pair(0, "zero"), Pair(1, "one"))

    // Many useful extension functions on Char...

    // Extensions on String
    // Formatting multiline strings
    val q = """To code,
        or not to code?"""
    println(q)
    val qq = """To code,
        |or not to code?"""
    println(qq.trimMargin())
    val qqq = """To code,
        #or not to code?"""
    println(qqq.trimMargin(marginPrefix = "#"))
    // If all lines have the same indent, this will remove them all
    val a = """
        Keep calm
        and learn Kotlin""".trimIndent()
    println(a)
    // Regex - toRegex extension function converts a string to regex object
    val regex = "\\d{2}.\\d{2}.\\d{4}".toRegex()
    //val regex = """\d{2}.\d{2}.\d{4}""".toRegex() // btw, with """ no need to escape \
    regex.matches("15.02.2016") // true
    regex.matches("15.02.16") // false
    // Conversion to numbers
    "123".toInt() // 123
    "1e-10".toDouble() // 1.0E-10
    "xx".toInt() // NumberFormatException
    "123".toIntOrNull() // 123
    "xx".toIntOrNull() // null

    // Let's create extension function: eq
    infix fun <T> T.eq(other: T) {
        if (this == other) println("OK")
        else println("Error: $this != $other")
    }
    fun getAnswer() = 42
    getAnswer() eq 42 // OK
    getAnswer() eq 43 // Error: 42 != 43
}