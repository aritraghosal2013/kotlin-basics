package SAMs

fun interface IPredicate<T: Any> {
    fun check(t: T): Boolean
}

class PredicateImplementation<T: Any>: IPredicate<T> {

    override fun check(t: T): Boolean {
        if(t is Int) {
            return t > 2
        } else if (t is Float) {
            return t > 2.0F
        }
        return true
    }
}

fun main() {

    // Using extension function to add my custom filter method to List interface
    fun<T: Any> List<T>.myOwnFilter(predicate: IPredicate<T>): List<T>  {
        val result = mutableListOf<T>()
        this.forEach {
            if(predicate.check(it)) {
                result.add(it)
            }
        }
        return result
    }

    val myList: List<Int> = listOf(1, 2, 3, 4, 5)
    val predicate1 = IPredicate<Int> {t -> t > 0 }

    println("Initial List:")
    println(myList)
    println("Filtered List")

    // Filtering integers by using my custom filter
    println(myList.myOwnFilter { t -> t > 2 })


    // Filtering for String
    val stringList: List<String> = listOf("Aritra", "Deepak", "Ramesh", "Naveen")
    stringList.myOwnFilter { t -> t.length > 8 }

}