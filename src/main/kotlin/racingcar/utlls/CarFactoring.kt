package racingcar.utlls

import racingcar.core.Car

object CarFactoring {

    fun createCars(carNames: List<String>): List<Car> {
        return carNames.map { Car(it) }
    }
}