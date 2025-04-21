package racingcar.util

import racingcar.domain.Car

object Convertor {

    fun convertNamesToCars(names: String): List<Car> {
        return names.split(",").map { Car(it) }
    }

    fun convertCarsToNames(cars: List<Car>): String {
        return cars.joinToString(",") { it.name}
    }
}