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

// interface Expr
sealed class Expr

// class Num(val value: Int) : Expr
class Num(val value: Int) : Expr()

// class Sum(val left: Expr, val right: Expr) : Expr
class Sum(val left: Expr, val right: Expr) : Expr()

fun eval(e: Expr): Int = when (e) {
    is Num -> e.value
    is Sum -> eval(e.left) + eval(e.right)
    // Without this else we would get compiler error - 'when' expression must be exhaustive, add necessary 'else' branch
    // This is happening because there is no guarantee that there are no other impl of Expr in other places and we are not covering them
    // else -> TODO("Not supported yet")
    // or like this
    // else -> throw IllegalArgumentException("Unknown expression")
    // BUT - if we change Expr interface to class add add sealed modifier:
    // That restricts class hierarchy - all subclasses / interface impls must be located in the same file!
    // In other words - only here we can implement it and nowhere else, so we are sure there is no more impls
}

interface Repository {
    fun getById(id: Int): Person
    fun getAll(): List<Person>
}

interface Logger {
    fun logAll()
}

// So sometimes we just want to delegate calls and we have to do this manually like this
class Controller(val repository: Repository, val logger: Logger) : Repository, Logger {
    override fun getById(id: Int): Person {
        return repository.getById(id)
    }

    override fun getAll(): List<Person> {
        return repository.getAll()
    }

    override fun logAll() {
        return logger.logAll()
    }
}

// BUT, in Kotlin we can do this, and it will automatically delegate, WOW! This is class delegation!
class Controller2(val repository: Repository, val logger: Logger) : Repository by repository, Logger by logger

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

    // Sealed classes
    // 1 + (2 + 3) = 6
    println(eval(Sum(Num(1), Sum(Num(2), Num(3)))))

    // Inner and nested classes - https://kotlinlang.org/docs/nested-classes.html

    // Class delegation - see Controller2 above!
}