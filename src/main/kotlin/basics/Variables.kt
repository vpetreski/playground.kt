package basics

fun main() {
    // Read-only variable; String type inference
    val foo = "foo"
    //val foo: String = "foo"
    println("Val = $foo")
    // Compiler error - val cannot be reassigned; Like final in Java
    //foo = "bar"

    // Mutable variable; Int type inference
    var bar = 1
    //var bar: Int = 1
    println("Var = $bar")
    bar = 2
    println("Var = $bar")

    // Mutable objects can, of course, be modified even when referenced with val; Only reference can't be changed
    val mutableList = mutableListOf("Java")
    mutableList.add("Kotlin")

    // No mutable methods
    val readOnlyList = listOf("Java")
    //readOnlyList.add("Kotlin")

    // Recommendations:
    // Prefer vals to vars
    // Specify types explicitly if they are not clear from the context
}