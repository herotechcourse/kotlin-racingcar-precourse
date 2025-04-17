package racingcar.application

import racingcar.domain.Car
import racingcar.domain.Cars
import racingcar.domain.NumberGenerator
import racingcar.domain.RacePolicy

class RaceExecutor(
    private val numberGenerator: NumberGenerator,
    private val cars: Cars,
    private val round: Int,
    private val racePolicy: RacePolicy
) {
    fun execute(): List<Cars> {
        val roundResults = mutableListOf<Cars>()
        repeat(round) {
            cars.moveIfSatisfied(this::canMoveCar)
            roundResults.add(cars.roundResult())
        }
        return roundResults
    }

    private fun canMoveCar(car: Car): Boolean {
        val number = numberGenerator.generate()
        return racePolicy.canMove(number)
    }
}
