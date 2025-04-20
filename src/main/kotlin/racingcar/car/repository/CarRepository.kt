package racingcar.car.repository

import racingcar.car.Car

interface CarRepository {
    fun addCar(name: String)
    fun addMultipleCars(cars: Array<String>)
    fun getAllCars(): List<Car>
}
