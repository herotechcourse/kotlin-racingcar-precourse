package racingcar

/**
 * Manages the racing game logic.
 * Handles car movements, tracks progress, and determines winners.
 *
 * @property cars The list of cars participating in the game.
 * @property rounds The total number of rounds the race will run.
 */
class Game(private val cars: List<Car>, private val rounds: Int) {
    /**
     * Starts the racing game and executes all rounds.
     * Displays the progress after each round and announces the winner(s).
     */

    fun start() {
        println()
        println( "Race Results")
        repeat(rounds) {
            playOneRound()
            displayProgress()
        }
        announceWinners()
    }
    /**
     * Runs one round of the game, moving each car.
     */
    private fun playOneRound() {
        cars.forEach { it.move() }
    }
    /**
     * Displays the current position of all cars.
     */
    private fun displayProgress() {
        cars.forEach { car ->
            println("${car.name} : ${"-".repeat(car.position)}") }
        println()
    }

    /**
     * Finds and prints the winners (cars with the max position).
     */
    private fun announceWinners() {
        val maxPosition = cars.maxOf { it.position }
        //val winners = cars.filter { it.position == maxPosition }
        //println("Winners: ${winners.joinToString(", ") { it.name }}")
        val winners = cars.filter { it.position == maxPosition }
            .joinToString(", ") { it.name }
        println("Winners : $winners")
    }

}

