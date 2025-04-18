package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms
import racingcar.model.Car

/**
 * RacingGame class manages the racing game logic, including car movements and determining winners.
 * @property cars List of cars participating in the race.
 * @property rounds Number of rounds in the race.
 */
class RacingGame(private val cars: List<Car>, private val rounds: Int) {

    companion object {
        private const val MIN_RANDOM_NUMBER = 0
        private const val MAX_RANDOM_NUMBER = 9
    }

    init {
        require(rounds > 0) { "Number of rounds must be greater than 0." }
    }

    /**
     * Starts the race and manages the progression of rounds.
     */
    fun startRace() {
        println("\nRace Results")

        repeat(rounds) {
            progressRound()
            displayRaceProgress()
            println()
        }

        displayWinners()
    }

    /**
     * Progresses the race by moving each car based on a random number.
     */
    private fun progressRound() {
        cars.forEach { car ->
            val randomCarPosition = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER)
            car.moveForward(randomCarPosition)
        }
    }

    /**
     * Displays the progress of all cars in the race.
     */
    private fun displayRaceProgress() {
        cars.forEach {
            println("${it.name} : ${it.progress()}")
        }
    }

    /**
     * Determines and displays the winners of the race.
     */
    private fun displayWinners() {
        val maxPosition = cars.maxOf { it.position }
        val winners = cars.filter { it.position == maxPosition }.map { it.name }
        println("Winners : ${winners.joinToString(", ")}")
    }
}