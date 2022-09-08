package oop

// const for primitive types and String; compile-time constant; the value is inlined
const val answer = 42

class MyClass

// Eliminates accessors
@JvmField
val prop = MyClass()

// ^ the same as Java
// public static final MyClass prop = new MyClass()

object P {
    @JvmField
    val prop = MyClass() // static field generated
}

class Q {
    @JvmField
    val prop = MyClass() // regular field generated
}

object SuperComputer {
    val answer = 2
}

// Java
// SuperComputer.INSTANCE.getAnswer()

object SuperComputer2 {
    @JvmStatic
    val answer = 2
}

// Java - field is not exposed, only through getter
// SuperComputer2.getAnswer()

object SuperComputer3 {
    @JvmField
    val answer = 2
}

// Java - field is exposed now
// SuperComputer3.answer

object SuperComputer4 {
    // For primitive types and String we can just use const
    const val answer = 2
}

// Java - field is exposed now
// SuperComputer4.answer

fun main() {

}