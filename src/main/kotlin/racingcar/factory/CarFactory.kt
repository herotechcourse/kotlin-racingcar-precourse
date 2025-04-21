package racingcar.factory

import racingcar.model.Car

class CarFactory {
    fun createCars(carNames: List<String>): List<Car> {
        return carNames.map { Car(it.trim()) }
    }
}