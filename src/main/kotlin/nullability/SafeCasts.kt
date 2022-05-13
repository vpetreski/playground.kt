package nullability

// Any is in Kotlin what Object is in Java
fun foo(any: Any) {
    // is like instanceof from Java
    if (any is String) {
        // as Type is a type cast in Kotlin
        // We are leaving it here for demonstration only, but, Kotlin is doing smart cast here because we already checked for: is String
        val s = any as String
        s.length

        // Smart cast
        any.length

        // We can even improve type cast to smart cast - as?
        // Type cast returns exception if expression can't be cast, but safe cast returns null in this case
        val ss = any as? String
        // So, ss can be null, so we use ?.
        ss?.length
        // foo as? Type
        // foo is Type => foo as Type
        // foo !is Type => null

    }

    val s: String? = any as? String
    // as? basically works like this
    val ss = if (any is String) any else null
}

// Type cast as throws ClassCastException, if the cast is unsuccessful.
// Safe cast as? returns null, if the cast is unsuccessful.
// Declare the s variable to make the first line print null and the second one throw an exception.
fun main(args: Array<String>) {
    val s = "foo"

    println(s as? Int) // null
    println(s as Int?) // exception
}