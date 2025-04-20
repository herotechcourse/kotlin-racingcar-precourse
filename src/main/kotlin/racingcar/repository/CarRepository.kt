package racingcar.repository

import racingcar.car.Car

interface CarRepository {
    fun addCar(name: String)
    fun addMultipleCars(cars: Array<String>)
    fun moveEveryCarRandomly()
    fun moveCarById(id: Int)
    fun getAllCars(): List<Car>
}
