package inline

class Email

open class User
class FacebookUser(val accountId: String) : User()
interface Session {
    val user: User
}

fun main() {
    // Useful library functions - pay attention how they look like language constructs, but they are just inline library functions

    // run - runs the block of code (lambda) and returns the last expression as the result
    val foo = run {
        println("Calculating foo...")
        "foo"
    }

    // let - allows to check the argument for being non-null, not only the receiver
    fun getEmail(): Email? { TODO() }
    fun sendEmail(email: Email) { TODO() }
    val email = getEmail()
    // We want to send an email only if it's not null, explicit if check is one option
    if (email != null) { sendEmail(email) }
    // But let is an alternative for coping with nulls:
    email?.let { e -> sendEmail(e) }
    // Or
    getEmail()?.let { sendEmail(it) }

    // Another use case for let for val/var coming from interfaces
    fun analyzeUserSession(session: Session) {
        // Remember that for val/var from interfaces can't be used in smart casts, so one trick is to define ne val before if check
        val user = session.user
        // Then smart cast is working
        if (user is FacebookUser) {
            println(user.accountId)
        }
    }
    // But - let gives us an alternative:
    fun analyzeUserSessionWithLet(session: Session) {
        // session.user as? FacebookUser will cast to FacebookUser if possible, otherwise null
        // Then we use ?.let again
        (session.user as? FacebookUser)?.let { println(it.accountId) }
    }

    // takeIf - returns the receiver object if it satisfies the given predicate, otherwise returns null
    val number = 42
    println(number.takeIf { it > 10 })
    // Using takeIf in chained calls!
    /*issues.filter { it.status == OPEN }
        .takeIf(List<Issue>::isNotEmpty)
        ?.let { println("There are some open issues") }*/
    // takeUnless - opposite of takeIf - returns the receiver object if it does NOT satisfy the given predicate, otherwise returns null

    // repeat - repeats an action for a given number of times
    repeat(10) {
        println("Welcome!")
    }
}