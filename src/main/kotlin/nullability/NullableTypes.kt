package nullability

// Modern approach - to make NPE compile-time error, not run-time error

fun main() {
    // Compile-time error
    // val s1: String = null

    // Non-nullable type
    val s1: String = "always not null"

    // Nullable type (can be both non-null and null)
    val s2: String? = null
    val s3: String? = "some string"

    // Compile-time error!
    // println(s2.length)
    // println(s3.length)

    // Can be done this way
    if (s3 != null) {
        println(s3.length)
    }

    // Better approach - safe access expression!
    // foo?.bar()
    // if foo != null => foo.bar()
    // if foo == null => null
    println(s2?.length) // null

    val s: String? = null
    // This
    val length = s?.length
    // Is same as
    // val length = if (s != null) s.length else null
    // length type is nullable int: Int? because operation s?.length was made on nullable type
    // val length: Int? = s?.length

    // If we want to get non-nullable type in this scenario, we have to use Elvis operator: ?:
    // So, we have to provide default value (0 in this case) when s? is null
    // When using if expression, we can simply say else 0 and when using safe access, we can use so-called Elvis operator
    // val length: Int = s?.length ?: 0
    // Elvis operator works like this:
    // foo ?: bar
    // if foo != null => foo
    // if foo == null => bar

    // Control-flow analysis
    val ss: String? = null
    // Compile-time error
    // ss.length
    // This is a correct way for nullable type
    // ss?.length
    // But, here we have smart-cast from nullable to non-nullable type via control-flow analysis, since we are checking for ss nullability:
    // if (ss == null) return // or fail()
    // ss.length

    // Not-null assertion
    // We can explicitly throw NPE if variable is null, if not it will return the value
    // foo!!
    // if foo != null => foo
    // if foo == null => NPE
    // After first assertion it will smart cast this to non-nullable type if ss is not null, so we don't have to repeat the assertion: ss!!.length
    // ss!!
    // ss.length

    // By default, try to avoid !! not-null assertion, but there are some use cases where Kotlin compiler isn't smart enough to infer correctly.
    // When you have an assumption that the expression is not null but the kotlin compiler cannot infer that for you.
    // And you would rather prefer an exception if for some reasons the assumption is not correct.
    // So, button can't be pressed if selectedValue is null, but we are just making sure that if that happens, we will throw NPE.
    // if (action.isEnabled()) {
    //     action.actionPerformed()
    // }
    // class MyAction {
    //     fun isEnabled(): Boolean = list.selectedValue != null
    //     fun actionPerformed() { val value = list.selectedValue!! }
    // }

    // Bad example of using not-null assertion
    // person.company!!.address!!.country
    // Prefer ?. and ?: and if-checks instead of !!

    // Under the hood Kotlin uses @NotNull annotation for non-nullable type and @Nullable for nullable type
    // Better performance comparing to Java's Optional since Kotlin doesn't create additional objects, just one to store the value + annotations

    // List of nullable elements - list elements might be null
    val l1: List<Int?>

    // Nullable list - list might be null
    val l2: List<Int>?

    // List of nullable elements AND nullable list
    val l3: List<Int?>?
}

// Lists and nullability
fun foo(list1: List<Int?>, list2: List<Int>?) {
    list1.size
    // 2nd list can be null
    list2?.size
    // Elements can be null
    val i: Int? = list1.get(0)
    // 2nd list can be null thus j can end up being null!
    val j: Int? = list2?.get(0)

}
