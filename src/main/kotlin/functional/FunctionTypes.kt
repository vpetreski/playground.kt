package functional

fun main() {
    // We can store lambdas in variables
    // This is the type of sum vars here: (Int, Int) -> Int
    val sum = { x: Int, y: Int -> x + y }
    val sum2: (Int, Int) -> Int = { x: Int, y: Int -> x + y }

    // (Int) -> Boolean
    val isEven = { i: Int -> i % 2 == 0 }
    val isEven2: (Int) -> Boolean = { i: Int -> i % 2 == 0 }
    // We can call stored lambda as regular function
    val result: Boolean = isEven(42)

    // We can pass a var of function type as an argument where lambdas are expected
    val list = listOf(1, 2, 3, 4)
    list.any(isEven)
    list.filter(isEven)

    // Calling lambda directly
    // { println("Hey!") }()
    // ^ Possible but looks strange, better use run for that:
    run { println("Hey!") }

    // SAM interfaces in Java: https://www.tutorialspoint.com/what-are-the-sam-interfaces-in-java
    // Code in Java - Runnable here is SAM interface in Java
    // void postponeComputation(int delay, Runnable computation)
    // From Kotlin we can just pass lambda there:
    // postponeComputation(1000) { println("Foo") }
    // Or
    // val runnable = Runnable { println("Foo") }
    // postponeComputation(1000, runnable)

    // Function types and nullability
    // Function type that returns nullable value
    // () -> Int?
    // VS
    // Nullable function type
    // (() -> Int)?
    // To understand the difference let's see which line here won't compile
    // Doesn't compile because we are expecting non-nullable function type
    // val f1: () -> Int? = null
    // Compiles because we provided non-nullable function type and returning nullable Int
    val f2: () -> Int? = { null }
    // Compiles because we provided nullable function type
    val f3: (() -> Int)? = null
    // Doesn't compile because we are not returning non-nullable Int
    // val f4: (() -> Int)? = { null }
    // Working with a nullable function type
    val f: (() -> Int)? = null
    // We can't call it like this because it's nullable
    // f()
    // One option is to surround it with null check
    if (f != null) {
        // Smart cast applies here
        f()
    }
    // Another option is to replace with safe ?. call
    f?.invoke()
    // Another option is to wrap with ?.let { ... }
    f?.let { it() }
}
