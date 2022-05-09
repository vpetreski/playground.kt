package cstruct

fun main() {
    // while and do-while loops are the same as in Java

    // For loops are a bit different
    val list = listOf("a", "b", "c")
    // in keyword
    for (s in list) {
        println(s)
    }
    // With element type
    for (s: String in list) {
        println(s)
    }
    // Iterating with index
    for ((index, value) in list.withIndex()) {
        println("$index: $value")
    }

    // Iterating over map
    val map = mapOf(1 to "one", 2 to "two", 3 to "three")
    for ((key, value) in map) {
        println("$key = $value")
    }

    // Iterating over range, including upper bound
    // 123456789
    for (i in 1..9) {
        print(i)
    }
    // Iterating over range with until, excluding upper bound
    // 12345678
    for (i in 1 until 9) {
        print(i)
    }

    // Iterating with a step; backwards
    // 97531
    for (i in 9 downTo 1 step 2) {
        print(i)
    }

    // Iterating over string
    // bcd
    for (ch in "abc") {
        print(ch + 1)
    }
}