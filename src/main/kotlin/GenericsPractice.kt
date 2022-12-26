enum class CarTypes(val carType: String) {
    LUXURY_CAR("luxury"),
    COMMERCIAL_CAR("commercial"),
    DOMESTIC_CAR("domestic")
}

class Car(val model: String, val type: CarTypes) {
}
class Aquarium<T: Any?>(val waterSupply: T)

class SpecializedCar <T :CarTypes> {

}


class BinaryOperation<P, Q> (private val p: P, private val q: Q, val operation : (P, Q) -> String) {

    fun add(): String {

        if((p is Int) && (q is Int )) {
            return (p.toDouble() + q.toDouble()).toString()
        }

        if ((p is Float) && (q is Float)) {
            return (p.toDouble() + q.toDouble()).toString()
        }
        return p.toString() + q.toString()
    }

    fun apply(): String {
        return operation(p, q)
    }

}

inline fun <reified T> genericFunction(value: T) {
    println(value)
    println("Type of T: ${T::class.java}")
}

fun main() {
    val addOp: BinaryOperation<Int, Int> = BinaryOperation(1, 2) { p, q -> (p + q).toString() }
    val a: Int = 2
    println("Type of a is " + a.javaClass)
    println(addOp.apply())
}