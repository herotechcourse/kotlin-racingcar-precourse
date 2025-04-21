package racingcar.service

import racingcar.domain.Car
import racingcar.output.OutputView
import racingcar.utils.Number
import racingcar.utils.RandomNumberGenerator

class CarService (
    private val cars: List<Car>,
    private val round: Int,
    private val outputView: OutputView
) {
    init {
        round >= Number.MINIMUM_ROUND_NUMBER
    }

    fun startRace() : List<Car> {
        repeat(round) {
            for (car in cars) {
                moveCar(car)
            }
            outputView.printCarPosition(cars)
        }
        return cars
    }

    private fun moveCar(car: Car) {
        val randomValue = RandomNumberGenerator.generateRandom()
        car.movePosition(randomValue)
    }
}