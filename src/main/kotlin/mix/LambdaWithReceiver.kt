package mix

import java.lang.StringBuilder

fun main() {
    // Lambda with receiver is concept that's basically like union of two ideas: Extension Function + Lambda

    // Example - the with function
    val sb = StringBuilder()
    sb.appendLine("Alphabet: ")
    for (c in 'a'..'z') {
        sb.append(c)
    }
    sb.toString()
    // ^ As usual (in Java) - we have to repeat sb.* for several operations. In Kotlin, we can use with for that:
    val sb2 = StringBuilder()
    with(sb2) {
        appendLine("Alphabet: ")
        for (c in 'a'..'z') {
            append(c)
        }
        toString()
    }
    // So here - with is lambda with receiver - lambda is code inside the with and receiver is sb2
    // with is just a regular function, not a language construct!
    // So again - with is regular function with 2 arguments, first is StringBuilder and second is lambda { code block }
    // 'this' is implicit receiver in the lambda, so we can remove it (like in extension functions)

    // Another lambda with receiver example - buildString - only one argument - the lambda, receiver is hidden here, but it's StringBuilder...
    val s: String = buildString {
        appendLine("Alphabet: ")
        for (c in 'a'..'z') {
            append(c)
        }
    }

    // Lambda with receiver is powerful mechanism, for example we can use it for HTML builders or Gradle Build Script in Kotlin, etc...
    // Basically ^ we can use Lambda with receiver to create DSL!

    // More useful library functions: with, run, let, apply, also
    // https://www.coursera.org/learn/kotlin-for-java-developers/lecture/pCrW2/more-useful-library-functions
    // run - like with, but can be used with nullable receiver: windowOrNull?.run { ... }
    // apply - returns receiver as a result: val mainWindow = windowOrNull?.apply { ... } ?: return
    // also - similar to apply, check the link above ^

}