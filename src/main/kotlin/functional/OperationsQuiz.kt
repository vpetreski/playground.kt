package functional

data class Hero(val name: String, val age: Int, val gender: Gender?)
enum class Gender { MALE, FEMALE }

val heroes = listOf(
    Hero("The Captain", 60, Gender.MALE),
    Hero("Frenchy", 42, Gender.MALE),
    Hero("The Kid", 9, null),
    Hero("Lady Lauren", 29, Gender.FEMALE),
    Hero("First Mate", 29, Gender.MALE),
    Hero("Sir Stephen", 37, Gender.MALE)
)

fun main() {
    // Sir Stephen
    println(heroes.last().name)

    // null
    println(heroes.lastOrNull { it.age == 30 }?.name)

    // NoSuchElementException
    // println(heroes.first { it.age == 30 }.name)

    // 5
    println(heroes.map { it.age }.distinct().size)

    // 3
    println(heroes.filter { it.age < 30 }.size)

    // 3
    val (youngest, oldest) = heroes.partition { it.age < 30 }
    println(oldest.size)

    // The Captain
    println(heroes.maxByOrNull { it.age }?.name)

    // false
    println(heroes.all { it.age < 50 })

    // true
    println(heroes.any { it.gender == Gender.FEMALE })

    //
    println()
}