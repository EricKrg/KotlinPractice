
// Builder pattern
abstract class Car(val engine: Engine,
                   val transmission: Transmission = StandardTransmission(),
                   var carState: CarState = FineState(),
                   var sports: Boolean = false,
                   var radio: Boolean = false,
                   var doors: Int = 4) {
    abstract fun turnOn()
    abstract fun turnOff()
    abstract fun drive()

    init {
        // Observer, register subjects
        // Car is observer of CarParts, which can i.e., breakdown and report the failure to the car and update the state
        transmission.updateState = ::changeState
        engine.updateState = ::changeState
    }


    private fun changeState(carState: CarState) {
        println("The CarState changed!")
        println("New State: ${carState.fetchState()}")
        this.carState = carState
    }

    fun addSports(): Car {
        this.sports = true
        return this
    }

    fun addRadio(): Car {
        this.radio = true
        return this
    }

    fun addDoors(count: Int): Car {
        this.doors = count
        return this
    }
}


// Car classes are Facades to car subsystems
class BMW(engine: Engine): Car(engine) {

    override fun turnOn() {
        print("turn on car")
        engine.generatePower()
        if (this.sports) {
            println("Rev engine unnecessary")
        }
    }

    override fun turnOff() {
    }

    override fun drive() {
        while (carState is FineState) {
            engine.generatePower()
            transmission.shift()
        }
    }
}


class Audi(engine: Engine): Car(engine) {

    override fun turnOn() {
        println("turn on car")
        engine.generatePower()
        if (this.sports) {
        }
        if (this.radio) {
            println("play music")
        }
    }

    override fun turnOff() {
    }

    override fun drive() {
    }
}

class Ford(engine: Engine): Car(engine) {
    override fun turnOn() {
        println("Break down")
    }

    override fun turnOff() {
        println("Break down")
    }

    override fun drive() {
        println("Break down")
    }
}