import kotlin.random.Random

abstract class Transmission(name: String) : CarPart(name) {
    abstract fun shift()
}

class StandardTransmission(name: String = "Standard Transmission") : Transmission(name) {
    override fun shift() {
        if (isWorking) {
            println("Shifting!")
            // random failure
            val rand = Random.nextInt(0, 5)
            if (rand == 0) {
                updateState(BrokenDownState(this))
                isWorking = false
                reportCondition()
            }
        } else {
            reportCondition()
        }
    }

    override fun reportCondition() {
        println(if (isWorking) "The Transmission is Working" else "The Transmission is not Working")
    }


}