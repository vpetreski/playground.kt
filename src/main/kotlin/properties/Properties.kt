package properties

// Properties 'name' and 'address' - Kotlin generated backing fields + accessors under the hood
class Contact(var name: String, val address: String)

class Rectangle(val height: Int, val width: Int) {
    // No backing field, only get accessor
    val isSquare: Boolean
        get() {
            return height == width
        }
}

class A {
    var trivialProperty: String = "abc"

    // Those below are automatically generated default accessors by Kotlin
    /*get() = field
    set(value: String) {
        field = value
    }*/
}

class StateLogger {
    // Property 'state', only inside accessors we can access backing 'field'
    // Kotlin generates backing field, get accessor and we redefined set accessor
    var state = false
        set(value) {
            println("State has changed: $field -> $value")
            // We can access 'field' only in accessors
            field = value
        }
}

class StateLogger2 {
    private var boolState = false

    // Here we defined 'state' property, redefined its accessors, but we are using another private property 'boolState' as a backing field
    var state: Boolean
        get() = boolState
        set(value) {
            boolState = value
        }
}

class LengthCounter {
    // Here we are using default implementation for accessors, but just changed visibility of setter, so that it can be used only internally
    var counter: Int = 0
        private set

    fun addWord(word: String) {
        counter += word.length
    }
}

fun main() {
    // Property 'name' and 'address' - when you access/set them, under the hood getters/setters are used
    // If you call this code from Java, you would have to use getters/setters
    // Or if you call Java code from Kotlin - you would use direct property, not get/set
    val contact = Contact("Foo", "Bar")
    contact.name = "FooFoo"

    // Can't do that since address is immutable (val), Contact class has 3 methods from Java point of view - get/set for name and get for address
    // contact.address = "BarBar"

    // Backing field could be absent, here we have isSquare getter method inside Rectangle and is accessed like direct property
    val rectangle = Rectangle(2, 3)
    println(rectangle.isSquare)

    // Backing 'field' - so here 'field' is storing the value for 'state' property; We don't work with fields externally, only with properties
    StateLogger().state = true

    // In this case we redefined accessors (get/set) and didn't use 'field' keyword, so in this case Kotlin won't generate backing 'field'
    // Here we used another property 'boolState' to store the value
    StateLogger2().state = true

    // Default accessors
    A().trivialProperty = "foobar"

    // We never use getter/setter directly, but always property directly, both inside and outside the class...
    // Of course, under the hood accessors are used, except when compiler does optimization, but that possible just INSIDE the class...

    // Visibility
    val lengthCounter = LengthCounter()
    lengthCounter.addWord("foo")
    // Getter OK
    println(lengthCounter.counter)
    // Can't be done, setter is private
    // lengthCounter.counter = 5;
}