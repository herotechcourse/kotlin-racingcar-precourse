package racingcar.storage

interface CarRepository {
    fun addCar(name: String)
    fun addMultipleCars(cars: Array<String>)
    fun moveCar(name: String)
}
