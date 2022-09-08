package oop

// import oop.Color.*

// `enum` is just a modifier for `class`!
enum class Color {
    ORANGE, BLUE, RED
}

fun getDescription(color: Color) =
    when (color) {
        Color.ORANGE -> "mild"
        Color.BLUE -> "hot"
        Color.RED -> "hot"
        // Or just like this if `import oop.Color.*`
        // ORANGE -> "mild"
        // BLUE -> "hot"
        // RED -> "hot"
    }

// enum class with properties and functions
enum class Color2(val r: Int, val g: Int, val b: Int) {
    ORANGE(255, 165, 0), BLUE(0, 0, 255), RED(255, 0, 0); // probably the only place in Kotlin where `;` is needed

    fun rgb() = (r * 265 + g) * 256 + b
}

// data modifier generate useful methods: equals, hashCode, copy, toString and others...
// Compiler uses only properties defined in primary constructor dor data classes!
// So if we define additional properties elsewhere, they are not take into account (for toString, equals and others coming from data class)
// This is also a way to exclude some properties for data.
// So for example - `nickname` will be excluded
data class Contact(val name: String, val address: String) {
    var nickname: String? = null
}

fun main() {
    println(getDescription(Color.RED))

    println(Color2.BLUE.r)
    println(Color2.BLUE.rgb())

    // data class
    val contact = Contact("Foo", "XYZ 123")
    // toString
    println(contact)
    // copy
    val anotherContact = contact.copy(name = "Bar")
    println(anotherContact)

    // While we are at data / equals
    val set1 = setOf(1, 2, 3)
    val set2 = setOf(1, 2, 3)
    // In Kotlin works like this:
    println(set1 == set2)  // == calls equals (true)
    println(set1 === set2) // === checks for reference equality (false)

    // Without data and explicit equals implementation, class would take default implementation for == (equals) which is === (reference) like in Java!


}