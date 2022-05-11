package extensions

// Change this sum function so that it is declared as an extension to List<Int>
fun sum2(list: List<Int>): Int {
    var result = 0
    for (i in list) {
        result += i
    }
    return result
}

// Solution
fun List<Int>.sum(): Int {
    var result = 0
    for (i in this) {
        result += i
    }
    return result
}

fun main(args: Array<String>) {
    println(sum2(listOf(1, 2, 3)))
    println(listOf(1, 2, 3).sum())
}