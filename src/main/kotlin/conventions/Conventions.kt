package conventions

fun main() {
    // Comparisons
    "abc" < "def"
    // a > b  -------> a.compareTo(b) > 0
    // a < b  -------> a.compareTo(b) < 0
    // a >= b -------> a.compareTo(b) >= 0
    // a <= b -------> a.compareTo(b) <= 0
    // You can compare your own classes like this ^ if you implement Comparable interface

    // Equality check, handling nulls automatically
    // s1 == s2

    // Accessing elements by index: []
    // map[key]
    // mutableMap[key] = newValue
    // a, b is a key below...
    // x[a, b]     -------> x.get(a, b)
    // x[a, b] = c -------> x.set(a, b, c)
    // For custom classes:
    // class Board
    // board[1, 2] = 'x'
    // board[1, 2] // 'x'
    // operator fun Board.get(x: Int, y: Int):  Char {//...}
    // operator fun Board.set(x: Int, y: Int, value: Chat) {//...}

    // The in convention
    // if (key in map) {}
    // if (element in list) {}
    // a in c -------> c.contains(a)

    // The rangeTo convention
    // if (s in "abc".."def") { }
    // for (i in 1..2) { }
    // val oneTo100: IntRange = 1..100
    // for (i in oneTo100) { }
    // start..end -------> start.rangeTo(end)
    // So we can also do this for our custom classes

    // The iterator convention
    // operator fun CharSequence.iterator(): CharIterator
    // for (c: in "abc") { }

    // Destructuring declarations
    // val (first, second) = pair
    //  -------> val first = pair.component1()
    //  -------> val second = pair.component2()
    // With data classes:
    data class Contact(val name: String, val email: String, val phone: String) {
        // generated methods
        // fun component1() = name
        // fun component2() = email
        // fun component3() = phone
    }
    val (name, _, phone) = Contact("foo", "bar", "123")

    // you can limit visibility like:
    // private operator ...
}