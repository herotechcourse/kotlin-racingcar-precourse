package racingcar.service

import racingcar.domain.Car
import racingcar.utils.Number
import racingcar.utils.RandomNumberGenerator

class CarRace (
    private val cars: List<Car>,
    private val round: Int
) {
    init {
        round >= Number.MINIMUM_ROUND_NUMBER
    }

    fun startRace() : List<Car> {
        for(car in cars) {
            moveCar(car)
        }
        return cars
    }

    private fun moveCar(car: Car) {
        val randomValue = RandomNumberGenerator.generateRandom()
        car.movePosition(randomValue)
    }
}