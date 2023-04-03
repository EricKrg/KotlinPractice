// State pattern
interface CarState {
    fun fetchState(): String
}

class FineState(): CarState{
    override fun fetchState(): String {
        return "Car is Fine"
    }
}


class WarnState(private val reason: CarPart): CarState {
    override fun fetchState(): String {
        return "Car is going to have a Problem, because of $reason"
    }
}

class BrokenDownState(private val reason: CarPart): CarState {
    override fun fetchState(): String {
        return "The car is broken, because of $reason"
    }
}

