object SingletonObj {
    var element: String = ""
    val name: String = "Aritra"

    fun displayObjDetails() {
        println("Object address is" + this.hashCode())
    }

}

fun main() {
    SingletonObj.displayObjDetails()
    SingletonObj.displayObjDetails()
}