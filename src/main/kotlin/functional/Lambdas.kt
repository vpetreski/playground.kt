package functional

// Lambda is an anonymous function that can be used as an expression
// For example - pass it as an argument to another function invocation
// button.addActionListener { println("Hi) }
// In older versions of Java anonymous classes were used for the same purpose
// button.addActionListener(new ActionListener() {
//     @Override
//     public void actionPerformed(ActionEvent e) {
//         System.out.println("Hi");
//     }
// });

fun main() {
    data class Employee(val city: String, val age: Int)

    val employees: List<Employee> = listOf()
    // Lambdas also allow us to work with collections in a functional style which makes overall code more readable
    // Average age of employees working in Prague
    employees.filter { it.city == "Prague" }
        .map { it.age }
        .average()

    // Lambda syntax
    // { parameters -> body }
    // { x: Int, y: Int, -> x + y }
    val numbers = listOf(1, 2, 3)
    // Full syntax
    numbers.any({ i: Int -> i > 0 })
    // When lambda is the last argument we can move it out of parentheses
    numbers.any() { i: Int -> i > 0 }
    // And if parentheses are empty, we can remove them and have nicer syntax
    numbers.any { i: Int -> i > 0 }
    // If type of the argument can be inferred, we can remove it
    numbers.any { i -> i > 0 }
    // it denotes the argument if it's the only one
    numbers.any { it > 0 }
    // Multi-line lambda
    numbers.any {
        println("Processing $it")
        it > 0
    }
    val numberMap = mapOf(1 to "one", 2 to "two")
    numberMap.mapValues { entry -> "${entry.key} -> ${entry.value}!" }
    // Use destructuring declaration instead
    numberMap.mapValues { (key, value) -> "$key -> $value!" }
    // Omit the parameter name if the parameter is unused
    numberMap.mapValues { (_, value) -> "$value!" }
}
