package cstruct

fun inUseCases() {
    for (i in 'a'..'z') {
        // Use case 1 - iteration
    }

    val c = 'b'
    if (c in 'a'..'z') {
        // Use case 2 - check for belonging
    }

    if (c !in 'a'..'z') {
        // not in range
    }
}

// in as when condition
fun recognize(c: Char) = when (c) {
    in '0'..'9' -> "Digit"
    in 'a'..'z', in 'A'..'Z' -> "Letter"
    else -> "Dunno"
}

// Range of custom type - implements Comparable
class MyDate : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        TODO("Not yet implemented")
    }
}

// Different ranges; We can store them in variables and use them
fun differentRanges() {
    // IntRange
    val intRange1: IntRange = 1..9
    val intRange2: IntRange = 1 until 10

    // CharRange
    val charRange: CharRange = 'a'..'z'

    // ClosedRange<String>
    val stringRange: ClosedRange<String> = "ab".."az"

    // ClosedRange<MyDate>
    val startDate = MyDate()
    val endDate = MyDate()
    val myDate = MyDate()
    val dateRange: ClosedRange<MyDate> = startDate..endDate
    // We can compare like this all the types implementing Comparable
    if (endDate > startDate) {
    }
    if (myDate in startDate..endDate) {
    }
    if (myDate in dateRange) {
    }
}

fun comparingStrings() {
    "ball" in "a".."k"
    // equivalent to:
    "a" <= "ball" && "ball" <= "k"
    // equivalent to:
    "a".compareTo("ball") <= 0 && "ball".compareTo("k") <= 0

    // By default, strings are compared lexicographically (by the alphabetical order), so:
    "ball" in "a".."k" // true
    "zoo" in "a".."k" // false
    "Kotlin" in "Java".."Scala" // true
}

fun belongingToCollection() {
    val list = listOf(1, 2, 3)
    if (2 in list) {
        // Same as list.contains(2) in Java
    }
}