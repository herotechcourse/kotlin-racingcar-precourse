package racingcar.model

import racingcar.util.RandomNumberGenerator

class RaceGame(
    private val cars: List<Car>,
    private var rounds: Int,
    private val randomNumberGenerator: () -> Int = { RandomNumberGenerator.generateRandomNumber() }
) {
    private var currentRound: Int = 0
    fun startRace() {
        while (!isRaceEnd()) {
            startRound()
        }
    }

    private fun startRound() {
        cars.forEach { car ->
            if (canMoveCar())
                car.move()
        }
        currentRound++
    }

    private fun canMoveCar(): Boolean = randomNumberGenerator() >= MIN_NUMBER_TO_MOVE_CAR

    private fun isRaceEnd(): Boolean = currentRound >= rounds

    fun getWinners(): List<Car> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }
    }

    companion object {
        const val MIN_NUMBER_TO_MOVE_CAR = 4
    }
}