package functional

class Person(val name: String, val age: Int) {
    fun isOlder(ageLimit: Int) = age > ageLimit

    // Bound to this reference
    fun getAgePredicate() = this::isOlder

    // this ^ can be omitted
    fun getAgePredicate2() = ::isOlder

    // How it really looks like
    fun getAgePredicate3(): (Int) -> Boolean = { ageLimit: Int -> this.isOlder(ageLimit) }
}

val people = listOf(Person("Foo", 26), Person("Bar", 31))


fun sendEmail(person: Person, message: String) {
    println("Sending message $message to ${person.name}")
}

fun main() {
    people.maxByOrNull { it.age }
    // Here we can convert ^ lambda to member reference
    people.maxByOrNull(Person::age)

    // We can store lambda in a variable
    val isEven: (Int) -> Boolean = { i: Int -> i % 2 == 0 }
    fun isEven2(i: Int): Boolean = i % 2 == 0
    // But we can't store function in a variable because of how JVM works - compiler error - so it's not like in truly function language
    // val predicate = isEven2
    // To fix this issue we can use function reference syntax
    val predicate = ::isEven2
    // Keep in mind that ^ is basically just another way to actually use the lambda:
    // Because in Kotlin we can really only store lambdas, not functions
    val predicate2 = { i: Int -> isEven2(i) }

    /*
      If a referred member is a property, or it's a function that takes 0 or 1 argument,
      then member reference syntax isn't that concise in comparison with explicit lambda syntax.
      However, if referred function takes several arguments, we have to repeat all the parameter names as lambda parameters.
      And then explicitly pass them through!
     */
    val action = { person: Person, message: String -> sendEmail(person, message) }
    action(people[0], "Some message")
    // In that case, member references allow us to hide all the parameters, because the compiler infers the types for us.
    val action2 = ::sendEmail
    action2(people[1], "Another message")

    // Passing function reference as an argument
    val list = listOf(1, 2, 3, 4)
    // When lambda is huge it makes sense to extract is as a function and call if like this
    list.any(::isEven2)
    list.filter(::isEven2)

    // Bound & non-bound references
    // Regular non-bound reference (since it's not bound to any specific instance) which refers to a member of the Person class
    val agePredicate = Person::isOlder
    // Inferred type was like here, notice the function type with a Person parameter!
    val agePredicate2: (Person, Int) -> Boolean = Person::isOlder
    // And under the hood it's really like this:
    val agePredicate3: (Person, Int) -> Boolean = { person, ageLimit -> person.isOlder(ageLimit) }
    val alice = Person("Alice", 29)
    // So, we need to pass the person instance explicitly
    agePredicate(alice, 21)
    agePredicate2(alice, 21)
    agePredicate3(alice, 21)
    // Bound reference is a member reference that is attached to a specific instance of the class (Alice in this case)
    val agePredicate4 = alice::isOlder
    // Inferred type was like here, notice the function type without a Person parameter now!
    val agePredicate5: (Int) -> Boolean = alice::isOlder
    // And under the hood it's really like this, again no Person parameter, we call it on alice directly:
    val agePredicate6: (Int) -> Boolean = { ageLimit -> alice.isOlder(ageLimit) }
    agePredicate4(21)
    agePredicate5(21)
    agePredicate6(21)

    // Bound to this reference - check the Person class and getAgePredicate*
    alice.getAgePredicate()(21)
    alice.getAgePredicate2()(21)
    alice.getAgePredicate3()(21)

    // ::isEven2 is non-bound reference, because it's not tied to any specific instance, it's just a reference to a top-level function
    // When we see ::something it's either a reference to non-bound to-level function or bound reference like in Person class and getAgePredicate
    list.any(::isEven2)
    list.filter(::isEven2)
}