package sequences

fun main() {
    // All functions created on Collection in Kotlin are inline, so that's good for perf optimization, as we already know
    // BUT, when we have chained calls, like filter > map > max, etc... for each call in the chain - new collection is created, thus overhead
    // Collections are doing eager evaluation

    // Solution for this are sequences, which can be compared to Java 8 Streams
    // Sequences are doing lazy evaluation and thus avoid creating intermediate collections

    // So how to convert from collection to sequence, it's simple - just add .asSequence()
    val list = listOf(1, 2, -3)
    val maxOddSquare = list
        //.asSequence() // immediately after the list, before chained calls!
        .map { it * it }
        .filter { it % 2 == 1 }
        .max()

    // Details on inner workings - https://www.coursera.org/learn/kotlin-for-java-developers/lecture/HwXl7/more-about-sequences

    // How to create sequence - https://www.coursera.org/learn/kotlin-for-java-developers/lecture/qHm1D/creating-sequences
}