import kotlin.random.Random

abstract class Engine(name: String) : CarPart(name) {
    abstract fun generatePower()
    abstract fun calcRange()
}

class EVEngine(name: String = "Electric Engine"): Engine(name) {
    override fun generatePower() {
        if (isWorking) {
            println("battery check")
            println("Engine Working!")
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

    override fun calcRange() {
        println("battery check")
        println("approx. range ${Random.nextInt(0, 100)} km")
    }

    override fun reportCondition() {
        println(if (isWorking) "Condition is OK" else "EV broke down")
    }
}

class V6Engine(name: String = "V6 Engine"): Engine(name) {
    override fun generatePower() {
        if (isWorking) {
            println("fuel tank sensor reading")
            println("idle rev 2000")

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

    override fun calcRange() {
        println("fuel tank sensor reading")
        println("approx. range ${Random.nextInt(0, 200)} km")
    }

    override fun reportCondition() {
        println(if (isWorking) "Condition is OK" else "V6 broke down")
    }
}