// Subject to Car
abstract class CarPart(
    private val name: String,
    var isWorking: Boolean = true,
    var updateState: (input: CarState) -> Unit = { println("update state not implemented") }) {

    abstract fun reportCondition()

    override fun toString(): String {
        return "CarPart: $name"
    }
}