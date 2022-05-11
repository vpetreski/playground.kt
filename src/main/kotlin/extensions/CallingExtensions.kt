package extensions

open class Parent
class Child : Parent()

fun Parent.foo() = "parent"
fun Child.foo() = "child"

// Converted to Java
// public static String foo(Parent parent) { return "parent"; }
// public static String foo(Child child) { return "child"; }

fun main() {
    // So this will work like general static functions, not inheritance!
    val parent: Parent = Child()
    // Like calling static method foo with Parent argument
    println(parent.foo()) // parent

    // Converted to Java
    // Parent parent = new Child();
    // So, type of the argument is Parent, so it chooses to call foo(Parent parent) static method
    // We don't know what will be assigned to Parent parent, so that's why this decision
    // System.out.println(foo(parent));

    // So, because extensions are static Java functions under the hood => no override for extension functions in Kotlin
    // To repeat - compiler will use argument type, not actual stored value, to decide which static function to call

    // Member vs Extension - what happens when we define an extension which duplicates a member?
    fun String.get(index: Int) = "*"
    // Member method in String already exists: public override fun get(index: Int): Char
    println("abc".get(1)) // b
    // So, extension is shadowed by a member, member always wins
    // However we can overload the member (different signature / param types / number of params):
    fun String.get() = "*"
    println("abc".get()) // *
}