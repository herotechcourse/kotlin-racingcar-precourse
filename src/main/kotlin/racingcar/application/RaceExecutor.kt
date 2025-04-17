package racingcar.application

import racingcar.domain.Car
import racingcar.domain.Cars
import racingcar.domain.NumberGenerator
import racingcar.domain.RacePolicy

class RaceExecutor(
    private val numberGenerator: NumberGenerator,
    cars: Cars,
    private val round: Int,
    private val racePolicy: RacePolicy
) {
    private var cars: Cars = cars

    fun execute(): List<Cars> {
        val roundResults = mutableListOf<Cars>()
        repeat(round) {
            cars = cars.movedIfSatisfied(this::canMoveCar)
            roundResults.add(cars.copyOfCurrent())
        }
        return roundResults
    }

    private fun canMoveCar(car: Car): Boolean {
        val number = numberGenerator.generate()
        return racePolicy.canMove(car, number)
    }
}
