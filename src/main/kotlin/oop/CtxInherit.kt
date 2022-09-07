package oop

// Kotlin generates default constructor if not present
class A

// Primary constructor here defines 2 properties - `name` and `age` are constructor parameters
// It's concise - we don't have to write the constructor code explicitly in the code here
class Person(val name: String, val age: Int)

// `brand` and `year` are constructor parameters (only accessors are defined) - note val/var - this creates properties!
class Car(val brand: String, val year: Int) {
    init {
        // And this is the constructor body, where we can do more complex init
        println("CTX Body")
    }
}

// Notice that here we don't have val/var, so accessor(s) / properties won't be defined automatically, this is now just constructor parameter
class Airplane(model: String) {
    // But now we can have property declaration like this
    val model: String

    init {
        // And initialize it here
        this.model = model
    }
}

// Changing visibility of a constructor
class InternalComponent
internal constructor(name: String) {
    //
}

class Rectangle(val height: Int, val width: Int) { // primary ctx
    // secondary ctx
    constructor(side: Int) : this(side, side) {
        //
    }

    // Another secondary ctx
    constructor() : this(100) {
        //
    }
}

// Different syntax for inheritance - we use the same `:` syntax for both `implements` (interface) and `extends` (class)
interface Base
class BaseImpl : Base
open class Parent
class Child : Parent() // notice the constructor call here
open class Parent2(val name: String)
class Child2(name: String) : Parent2(name) // notice the constructor call here with parameter and no `val name: String`, just `name: String`
class AnotherChild2 : Parent2 {
    constructor(name: String, param: Int) : super(name) // or can be done like this - with `super`
}

fun main() {
    // Default constructor; No `new` keyword
    val a = A()

    // Concise PRIMARY constructor
    val person = Person("Foo", 18)
    println(person.age)

    val car = Car("BMW", 2022)
    println(car.brand)

    val plane = Airplane("F-16")
    println(plane.model)

    val rect = Rectangle(10)
    println(rect.width)
}