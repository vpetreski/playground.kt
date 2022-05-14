package functional

// Many operations on collections in Kotlin are extension functions (like filter, map, average...)

fun main() {
    val numbers = listOf(1, 2, 3, 4)
    // Filter - only elements that satisfy given predicate
    println(numbers.filter { it % 2 == 0 }) // [2, 4]

    // Map - transforms each element in the collection and store transformed elements in the new list
    println(numbers.map { it * it }) // [1, 4, 9, 16]

    // Any, All, None - checking whether the given facts about the elements are true
    println(numbers.any { it % 2 == 0 }) // true
    println(numbers.all { it % 2 == 0 }) // false
    println(numbers.none { it % 2 == 0 }) // false

    // Find - finds first element that satisfied the predicate, null if no result
    println(numbers.find { it % 2 == 0 }) // 2
    // Same as find
    println(numbers.firstOrNull { it % 2 == 0 }) // 2
    // Same as find, but throws an exception if no result
    println(numbers.first { it % 2 == 0 }) // 2

    // Count - counts number of elements satisfying the given predicate
    println(numbers.count { it % 2 == 0 }) // 2

    // Partition - divides collection in two collections, one satisfying and other not satisfying the predicate
    println(numbers.partition { it % 2 == 0 }) // ([2, 4], [1, 3])

    data class Person(val name: String, val age: Int)
    // GroupBy - grouping elements into map by specified key
    val people: List<Person> = listOf(Person("Alice", 31), Person("Bob", 29), Person("Carol", 31))
    println(people.groupBy { it.age }) // {31=[Person(name=Alice, age=31), Person(name=Carol, age=31)], 29=[Person(name=Bob, age=29)]}

    // AssociateBy - gives map with values as only one element by specified key
    // Should be unique to show all elements - duplicates are removed and only last element is chosen
    println(people.associateBy { it.name }) // {Alice=Person(name=Alice, age=31), Bob=Person(name=Bob, age=29), Carol=Person(name=Carol, age=31)}

    // Associate - build a map based on list, lambda contains key-value pair based on each list element
    println(numbers.associate { 'a' + it - 1 to 10 * it }) // {a=10, b=20, c=30, d=40}

    val letters = listOf('a', 'b', 'c', 'd')
    // Zip - provides a way to organize a couple of lists, result is a list of pairs
    // Both list should have the same number of elements or smaller list will be taken as reference for number of elements in the result.
    println(numbers.zip(letters)) // [(1, a), (2, b), (3, c), (4, d)]

    // ZipWithNext - zips neighboring elements in the list
    println(numbers.zipWithNext()) // [(1, 2), (2, 3), (3, 4)]

    // Both zip and zipWithNext have overloaded versions taking a lambda as an argument that specifies how each pair of elements must be transformed.
    println(numbers.zip(letters) { n, l -> n * n to l }) // [(1, a), (4, b), (9, c), (16, d)]

    // Flatten - extension function that must be called on list of lists - joins the lists into one list
    val listOfLists = listOf(letters, listOf('e', 'f'), listOf('g', 'h'))
    println(listOfLists.flatten()) // [a, b, c, d, e, f, g, h]

    // FlatMap - combines two operations: map and flatten
    // So, lambda expression is doing mapping here and transforms ["123", "45"] to [[1, 2, 3], [4, 5]]m then flatten them to [1, 2, 3, 4, 5]
    val listOfStringNumbers = listOf("123", "45")
    // println(listOfStringNumbers.map { it.toList() }) // [[1, 2, 3], [4, 5]]
    println(listOfStringNumbers.flatMap { it.toList() }) // [1, 2, 3, 4, 5]
}
