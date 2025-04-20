package racingcar.model

import racingcar.util.RandomNumberGenerator

class RaceGame(
    private val cars: List<Car>,
    private var rounds: Int,
    private val randomNumberGenerator: () -> Int = { RandomNumberGenerator.generateRandomNumber() }
) {
    private var currentRound: Int = 0

    fun startRound() {
        cars.forEach { car ->
            if (canMoveCar())
                car.move()
        }
        currentRound++
    }

    fun getListOfCars(): List<Car> {
        return cars
    }

    fun isRaceEnd(): Boolean = currentRound >= rounds

    private fun canMoveCar(): Boolean = randomNumberGenerator() >= MIN_NUMBER_TO_MOVE_CAR


    fun getWinners(): List<String> {
        val maxPosition = cars.maxOf { it.position }
        val winningCars = cars.filter { it.position == maxPosition }
        return winningCars.map { it.name }
    }

    companion object {
        const val MIN_NUMBER_TO_MOVE_CAR = 4
    }
}