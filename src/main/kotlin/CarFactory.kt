
// factory pattern
class CarFactory {
    fun createCar(brand: CarBrand,isEv: Boolean, sports: Boolean, radio: Boolean, doors: Int = 5): Car {
        val engine = if (isEv) EVEngine() else V6Engine()
        val car = when (brand) {
            CarBrand.BMW -> BMW(engine)
            CarBrand.AUDI -> Audi(engine)
            CarBrand.FORD -> Ford(engine)
        }
        if (sports) {
            car.addSports()
        }

        if (radio) {
            car.addRadio()
        }
        car.addDoors(doors)
        return car
    }
}

enum class CarBrand {
    AUDI, BMW, FORD
}