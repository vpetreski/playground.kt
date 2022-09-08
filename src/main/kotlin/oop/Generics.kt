package oop

// Generic interfaces and classes
interface MyList<E> {
    fun get(index: Int): E
}

fun foo(ints: MyList<Int>) {
    //
}

fun bar(string: MyList<String>) {
    //
}

// Generic functions
fun <T> MyList<T>.filter(predicate: (T) -> Boolean): MyList<T> {
    TODO()
}

fun main() {
    // https://www.coursera.org/learn/kotlin-for-java-developers/lecture/ZnSIz/generics
    // https://kotlinlang.org/docs/generics.html
}