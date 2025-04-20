package racingcar

import camp.nextstep.edu.missionutils.Randoms

/**
 * Manages the racing game logic for a given list of cars.
 *
 * Handles round-based movement and prints the race progress
 * after each round. Each car moves forward if a randomly generated
 * number between 0 and 9 is 4 or higher.
 *
 * @property cars The list of [Car] instances participating in the race.
 */
class RacingGame (private val cars: List<Car>){
    /**
     * Runs the racing game for the given number of rounds.
     *
     * Each round consists of:
     * - Generating a random number for each car
     * - Moving the car if the number is 4 or higher
     * - Printing the car's progress after the round
     *
     * @param rounds The total number of rounds to run. Must be > 0.
     */
    fun play(rounds: Int) {
        println("\nRace results")
        repeat(rounds) {
            runRound()
            printProgress()
        }
    }

    /**
     * Executes one round of the game.
     *
     * Each car receives a random number and moves
     * forward if the number is 4 or greater.
     */
    private fun runRound() {
        cars.forEach { car ->
            val ran = Randoms.pickNumberInRange(0, 9)
            if (ran >= 4)
                car.move()
        }
    }

    /**
     * Prints the current progress of all cars.
     *
     * Displays each car's name followed by a number of dashes
     * representing its current position on the track.
     */
    private fun printProgress() {
        cars.forEach { println(it) }
        println()
    }
}