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

    // 29
    val mapByAge: Map<Int, List<Hero>> = heroes.groupBy { it.age }
    val (age, group) = mapByAge.maxByOrNull { (_, group) -> group.size }!!
    println(age)

    // 42
    val mapByName: Map<String, Hero> = heroes.associateBy { it.name }
    println(mapByName["Frenchy"]?.age)
    // NoSuchElementException if no element!
    println(mapByName.getValue("Frenchy").age)

    // 0
    val mapAgesByName = heroes.associate { it.name to it.age }
    println(mapAgesByName.getOrElse("UnknownName") { 0 })

    // The Captain
    // Example of bad written code hard to read - DO NOT DO THIS
    val (frst, scnd) = heroes
        .flatMap { heroes.map { hero -> it to hero } } // it is from flatMap, hero is from heroes
        .maxByOrNull { it.first.age - it.second.age }!! // it here is from maxByOrNull which refers to a Pair of heroes
    // So for each it from flatMap, let's call it foo, to illustrate, we will get a Pair with each hero
    println(heroes.map { hero -> "foo" to hero })
    // So we will have a list of lists - each combination of heroes
    println(heroes.flatMap { heroes.map { hero -> it to hero } })
    // Since The Captain is the oldest, difference with him and the youngest will win
    println(frst.name)

    // The Captain
    // It's better to use explicit lambda parameters (no it), extracting intermediate variables and proper naming, for clarity in these situations
    val allPossiblePairs = heroes
        .flatMap { first -> heroes.map { second -> first to second } }
    val (theOldest, theYoungest) = allPossiblePairs
        .maxByOrNull { it.first.age - it.second.age }!!
    println(theOldest.name)

    // The Captain
    // But if we think what that code is doing, we actually really need this
    println(heroes.maxByOrNull { it.age }?.name)
}