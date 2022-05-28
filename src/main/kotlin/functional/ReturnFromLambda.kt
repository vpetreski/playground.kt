package functional

fun duplicateNonZero(list: List<Int>): List<Int> {
    return list.flatMap {
        if (it == 0) return listOf()
        listOf(it, it)
    }
}

fun main() {
    // NOT [3, 3, 5, 5]
    // BUT [] - because return ALWAYS return from fun function, not lambda!
    // So in second iteration it stumbled upon 0 and return empty list for the whole fun function
    val lst = listOf(3, 0, 5)
    println(duplicateNonZero(lst))

    // So, why return from function?

    // Here, return true returns from function, that's clear
    fun containsZero(list: List<Int>): Boolean {
        for (i in list) {
            if (i == 0) return true
        }
        return false
    }

    // Let's convert this to forEach (functional style)
    fun containsZero2(list: List<Int>): Boolean {
        // So we have to expect the same behaviour - to return from the whole function, not lambda!
        list.forEach {
            if (it == 0) return true
        }
        return false
    }

    // Let's now see what can we do if we need to return from a lambda, like in duplicateNonZero
    fun duplicateNonZero2(list: List<Int>): List<Int> {
        return list.flatMap {
            // using label with return to specify we want to return from flatMap lambda!
            if (it == 0) return@flatMap listOf()
            listOf(it, it)
        }
    }

    // Now yes - [3, 3, 5, 5]
    println(duplicateNonZero2(lst))

    // Instead of using name of the function accepting our lambda, we can also set custom label like this
    fun duplicateNonZero3(list: List<Int>): List<Int> {
        return list.flatMap l@{
            // using label with return to specify we want to return from flatMap lambda!
            if (it == 0) return@l listOf()
            listOf(it, it)
        }
    }

    // There is another solution to the same problem - using local function
    fun duplicateNonZero4(list: List<Int>): List<Int> {
        fun duplicateNonZeroElement(e: Int): List<Int> {
            // Classic return here returns from duplicateNonZeroElement only, not from duplicateNonZero4, so it's ok!
            if (e == 0) return listOf()
            return listOf(e, e)
        }
        // Using reference to the local function
        return list.flatMap(::duplicateNonZeroElement)
    }
    // Again - [3, 3, 5, 5]
    println(duplicateNonZero4(lst))

    // And alternative solution to ^ using anonymous function
    fun duplicateNonZero5(list: List<Int>): List<Int> {
        // Notice fun(e: Int): List<Int> anonymous function without a name
        return list.flatMap(fun(e: Int): List<Int> {
            // Classic return here returns from anonymous only, not from duplicateNonZero4, so it's ok!
            if (e == 0) return listOf()
            return listOf(e, e)
        })
    }
    // Additional benefit with anonymous functions comparing to lambda, is that we can specify the return type - List<Int> in this case
    // Again - [3, 3, 5, 5]
    println(duplicateNonZero5(lst))

    // Yet another solution by avoiding return
    fun duplicateNonZero6(list: List<Int>): List<Int> {
        return list.flatMap {
            if (it == 0)
                listOf()
            else
                listOf(it, it)
        }
    }
    // Again - [3, 3, 5, 5]
    println(duplicateNonZero6(lst))

    // Personally, the most readable solution is duplicateNonZero2, duplicateNonZero3 and duplicateNonZero6

    // Labeled return inside forEach corresponds to continue inside for loop
    lst.forEach {
        if (it == 0) return@forEach
        print(it)
    }
    println()
    // The same as
    for (e in lst) {
        if (e == 0) continue
        print(e)
    }
}