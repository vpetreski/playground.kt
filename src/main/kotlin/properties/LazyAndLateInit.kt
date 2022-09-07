package properties

val lazyValue: String by lazy { // lazy is taking lambda to compute the value
    println("Computed!")
    "Hello"
}

class Foo {
    var myData1: String? = null
    lateinit var myData2: String // lateinit has to be var, can't be val nad of course can't be nullable and can't be primitive type

    fun someLateInit() {
        myData1 = "foo"
        // We can check like this if lateinit var was initialized or not
        println(this::myData2.isInitialized) // using property reference - this::myData2
        myData2 = "foo"
        println(this::myData2.isInitialized)
    }

    fun bar() {
        // Since data is initialized later = mydata1 is of nullable type and has null as initial value
        // So we have to use ?. always, even we know that after late init it will always be non null and that's pain
        println(myData1?.length)
        // For lateinit mydata2 we can access it normally without ?. because we know it will be initialzied later!
        println(myData2.length)
    }
}

fun main() {
    // Lazy properties

    println("In main...")
    // Not computed if not called - lazy!
    // If called multiple times - will be computed only once!
    // println(lazyValue)
    // println(lazyValue)

    // Late initialization
    val foo = Foo() // data is not initialized in constructor
    // UninitializedPropertyAccessException: lateinit property myData2 has not been initialized
    // foo.bar()
    foo.someLateInit() // some late init
    foo.bar()

}