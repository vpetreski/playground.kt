package basics

// Main with args; Array syntax
fun main(args: Array<String>) {
    // array wrappers; if is an expression
    val name = if (args.isNotEmpty()) args[0] else "Kotlin"
    // String templates
    println("Hello $name!")
    println("Hello ${args.getOrNull(0)}!")
}
