package racingcar.storage

interface CarRepository {
    fun addCar(name: String)
    fun addMultipleCars(cars: Array<String>)
    fun moveEveryCarRandomly()
    fun moveCarById(id: Int)
}
