package racingcar

import camp.nextstep.edu.missionutils.Randoms

/**
 * Manages the execution of the car race.
 *
 * @property cars the list of cars participating in the race
 * @property rounds the number of rounds in the race
 */
class Race(private val cars: List<Car>, private val rounds: Int) {

    private val positions: MutableList<Int> = MutableList(cars.size) { 0 }

    companion object {
        /**
         * Threshold for moving a car forward.
         */
        const val MOVING_FORWARD: Int = 4

        /**
         * Threshold for stopping a car.
         */
        const val STOP: Int = 3
    }

    /**
     * Retrieves the current positions of all cars.
     *
     * @return a list of positions corresponding to each car
     */
    fun getPositions(): List<Int> {
        return positions
    }

    /**
     * Executes the race for the specified number of rounds.
     */
    fun runTheRace() {
        repeat(rounds) {
            moveCarsIfEligible()
        }
    }

    /**
     * Determines the winners of the race based on the highest position.
     *
     * @return a list of cars that have the highest position
     */
    fun getWinners(): List<Car> {
        val maxPosition = positions.maxOrNull() ?: 0
        return cars.filterIndexed { index, _ -> positions[index] == maxPosition }
    }

    /**
     * Moves cars forward if they meet the random number threshold.
     */
    private fun moveCarsIfEligible() {
        for (index in positions.indices) {
            val randomNumber = Randoms.pickNumberInRange(0, 9)
            if (randomNumber >= Race.MOVING_FORWARD) {
                positions[index] += 1
            }
        }
    }
}