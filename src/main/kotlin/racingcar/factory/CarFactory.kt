package racingcar.factory

import racingcar.model.Car

object CarFactory {
    fun createCars(carNames: List<String>): List<Car> {
        return carNames.map { Car(it.trim()) }
    }
}