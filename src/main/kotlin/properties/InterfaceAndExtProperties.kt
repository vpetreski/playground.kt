package properties

import java.lang.StringBuilder

interface User {
    // Abstract immutable property
    val nickname: String
}

class FacebookUser(private val accountId: Int) : User {
    // So we have to override here to get the value, pay attention - no custom getter here!
    override val nickname: String = getFacebookName(accountId)

    private fun getFacebookName(accountId: Int): String = TODO("Not yet implemented")
}

class SubscribingUser(private val email: String) : User {
    // So we have to override here to get the value, but this time we are creating custom getter
    override val nickname: String
        get() = email.substringBefore("@")
}

// Extension properties - the syntax and logic are similar to extension functions
// Note that we use val here instead of fun
val String.lastIndex: Int // note val - immutable
    get() = this.length - 1 // 'this' could be omitted

val String.indices: IntRange // note val - immutable
    get() = 0..lastIndex // here we don't use 'this'

var StringBuilder.lastChar: Char // note var - mutable
    // get() = this.get(length - 1)
    get() = get(length - 1)
    set(value) {
        // this.setCharAt(length - 1, value)
        setCharAt(length - 1, value)
    }

fun main() {
    // Properties in interfaces

    val facebookUser = FacebookUser(123)
    // Getter for nickname is calculated only once and value stored in a field, because we don't have custom getter there
    // facebookUser.nickname
    // facebookUser.nickname

    val subscribingUser = SubscribingUser("some@email.com")
    // It's calculated every time, so no backing field, because we have custom getter there
    // subscribingUser.nickname
    // subscribingUser.nickname

    // Extension properties - so not calling a function, but accessing properties
    println("abc".lastIndex)
    println("abc".indices)
    // Mutable extension property
    val sb = StringBuilder("Kotlin?")
    sb.lastChar = '!'
    println(sb)
}