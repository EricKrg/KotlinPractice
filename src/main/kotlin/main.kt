

fun main() {
    val carFactory = CarFactory()
    var audi: Car = carFactory.
    createCar(CarBrand.AUDI,
        isEv = false, sports = false, radio = true)

    val audiE: Car = carFactory.
    createCar(CarBrand.AUDI,
        isEv = true, sports = true, radio = true)

    val bmw: Car = carFactory.createCar(CarBrand.BMW, isEv = false, radio = true, sports = false)

    audi.turnOn()
    audiE.turnOn()

    bmw.turnOn()
    bmw.drive()


}
