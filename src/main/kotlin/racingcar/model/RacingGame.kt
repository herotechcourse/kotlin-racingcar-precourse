package racingcar.model

/**
 * Represents a racing game, managing a list of cars and a specified number of rounds.
 *
 * The game involves cars moving based on a random number generator and determines the winner(s)
 * based on their positions after all rounds are completed.
 *
 * @property cars The list of cars participating in the race.
 * @property numberOfRounds The number of rounds the race will consist of.
 */
class RacingGame (private val cars: MutableList<Car>, private val numberOfRounds: Int) {

    fun startGame() {
        println("Race Results")
        repeat(numberOfRounds) {
            cars.forEach { it.move() }
            cars.forEach { println(it.printPosition()) }
            println()
        }
        val winners = findWinner()
        val winnerNames = winners.joinToString(separator = ", ") { it.name }
        println("Winners : $winnerNames")
    }

    fun findWinner() : MutableList<Car> {
        val maxPosition = cars.maxOf { it.position }
        val winners = cars.filter { it.position == maxPosition }
        return winners.toMutableList()
    }
}