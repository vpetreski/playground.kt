package nullability

// Add and implement an extension function 'isEmptyOrNull()' on the type String?
// It should return true, if the string is null or empty

// Is string is null we take 0 as its length
fun String?.isEmptyOrNull() = (this?.length ?: 0) == 0

// Since we first check for null, later we can use this because to non-null string cast
fun String?.isEmptyOrNull2() = this == null || this.isEmpty()

// Remember that we can omit "this"
fun String?.isEmptyOrNull3() = this == null || isEmpty()

fun main(args: Array<String>) {
    val s1: String? = null
    val s2: String? = ""
    println(s1.isEmptyOrNull()) // true
    println(s2.isEmptyOrNull()) // true

    val s3 = "   "
    println(s3.isEmptyOrNull()) // false

    // There is already existing method for this
    s1.isNullOrEmpty()
    // Blank is, for example, also "    "
    s2.isNullOrBlank()
}