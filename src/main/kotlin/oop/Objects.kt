package oop

import java.awt.Window
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent

// Like this we create both a class and (single) instance of that class - an object
// In Java we would typically have to use singleton pattern to implement this ourselves with static INSTANCE of private ctx
// And this is exactly what Kotlin is doing under the hood
// This is top level object, but can be inside a class, etc..
object KSingleton {
    fun foo() {}
}

// special object inside a class - companion object
class X {
    companion object {
        fun foo() = 1
    }
}

interface Factory<T> {
    fun create() : T
}

class Y private constructor() { // btw - a way to change primary constructor visibility
    // companion object can implement an interface, while static methods in Java can't do that
    companion object : Factory<Y> {
        override fun create(): Y {
            return Y()
        }
    }
}

// If you want to call static method from companion object from Java directly - you have to add @JvmStatic for that function
// Keep in mind that from Java this is OK - C.Companion.bar()
class C {
    companion object {
        @JvmStatic fun foo() {}
        fun bar() {}
    }
}

// Same is for object singleton - now from Java this is OK - Obj.foo()
// In this case from Java this is still OK - Obj.INSTANCE.bar()
object Obj {
    @JvmStatic fun foo() {}
    fun bar() {}
}

fun main() {
    // object = singleton in Kotlin!
    KSingleton.foo()
    // From Java we would call this Kotlin object like this:
    // KSingleton.INSTANCE.foo()

    // object expressions - it basically just replace Java's anonymous classes, so this is how we do that in Kotlin
    // Whenever interface has a single method, then we can use lambda, no need for this, but if there are multiple methods - object expression is the way
    // Have in mind that object expression is not a singleton (like singleton object above) - so if we call this code block multiple times:
    // We will create multiple instances of MouseAdapter!
    val window: Window? = null
    window?.addMouseListener(
        object : MouseAdapter() {
            override fun mouseClicked(e: MouseEvent?) {
                super.mouseClicked(e)
            }

            override fun mouseEntered(e: MouseEvent?) {
                super.mouseEntered(e)
            }
        }
    )

    // Companion object - in Kotlin there is no concept of static methods in classes, so companion object can be a replacement for that!
    X.foo()
    // Better than static - can impl interfaces - see Y
    Y.create()
    // Companion object can be a receiver of extension function
    fun Y.Companion.someExtFun() {}
    // So it's basically like adding new static classes to the class, but externally
    Y.someExtFun()

    // There is no static keyword, declare "static" members like this:
    // - at the top level!
    // - inside objects
    // - inside companion objects
}