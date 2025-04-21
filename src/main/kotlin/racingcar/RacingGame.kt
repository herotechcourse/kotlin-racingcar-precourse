package racingcar

/**
 * This class is responsible for representing the core game logic for the racing car game.
 */
class RacingGame(private val cars: List<Car>, private val rounds: Int) {

    /**
     * This class is responsible for starting the race by repeating the game for the specified
     * number of rounds.
     *
     * Each round:
     * - Moves each car based on random logic.
     * - Displays the current state of each car.
     */
    fun startRace() {
        repeat(rounds) {
            cars.forEach { it.move() }
            displayRound()
        }
    }

    /**
     * This method is responsible for displaying the progress of all cars after each round.
     * Each car's name and current position is printed.
     */
    private fun displayRound() {
        cars.forEach { println(it.display()) }
        println()
    }

    /**
     * This method is responsible for determining the cars that have traveled the longest distance.
     *
     * @return A list of winner car objects. If multiple cars are tied for the longest position,
     *         all are returned.
     */
    fun getWinners(): List<Car> {
        val max = cars.maxOf { it.getPosition() }
        return cars.filter { it.getPosition() == max }
    }
}
