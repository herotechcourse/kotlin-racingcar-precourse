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
        repeat(rounds) {
            playOneRound()
            displayProgress()
        }
        announceWinners()
    }

}

