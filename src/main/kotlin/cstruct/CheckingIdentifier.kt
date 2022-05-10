package cstruct

// Implement the function that checks whether a string is a valid identifier.
// A valid identifier is a non-empty string that starts with a letter or underscore and consists of only letters, digits and underscores.

// This is to practice ranges
fun isValidIdentifier(s: String): Boolean {
    fun isValidCharacter(c: Char) = c == '_' || c in '0'..'9' || c in 'a'..'z' || c in 'A'..'Z'

    if (s.isEmpty() || s[0] in '0'..'9') {
        return false
    }

    for (c in s) {
        if (!isValidCharacter(c)) return false
    }

    return true
}

// In real life we would use existing Char methods: isDigit and isLetterOrDigit.
fun isValidIdentifier2(s: String): Boolean {
    fun isValidCharacter(c: Char) = c == '_' || c.isLetterOrDigit()

    if (s.isEmpty() || s[0].isDigit()) {
        return false
    }

    for (c in s) {
        if (!isValidCharacter(c)) return false
    }

    return true
}

fun main(args: Array<String>) {
    println(isValidIdentifier("name"))   // true
    println(isValidIdentifier("_name"))  // true
    println(isValidIdentifier("_12"))    // true
    println(isValidIdentifier(""))       // false
    println(isValidIdentifier("012"))    // false
    println(isValidIdentifier("no$"))    // false
    println("-----")
    println(isValidIdentifier2("name"))   // true
    println(isValidIdentifier2("_name"))  // true
    println(isValidIdentifier2("_12"))    // true
    println(isValidIdentifier2(""))       // false
    println(isValidIdentifier2("012"))    // false
    println(isValidIdentifier2("no$"))    // false
}