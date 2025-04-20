package racingcar

/**
 * RaceGame class
 *
 * @constructor: creates a race with cars and rounds
 * @param cars: list of cars -> private and read-only
 * @param rounds: number of rounds -> private and read-only
 *
 * @see runRace: runs all rounds and prints the race results after each round,
 * prints the winners at the end
 * @see printWinners: prints the winner or winners
 */
class RaceGame(private val cars: List<Car>, private val rounds: Int) {
    fun runRace() {
        println("\nRace Results")
        for (i in 0..rounds) {
            cars.forEach {
                it.move();
                it.printProgress()
            }
            println()
        }
        printWinners()
    }

    private fun printWinners() {
        val maxMoveCount = cars.maxOf { it.moveCount }
        print("Winners : ")
        val winners = cars.filter() {
            it.moveCount == maxMoveCount
        }
        for (winner in winners) {
            if (winners.indexOf(winner) == winners.size - 1)
                print(winner.carName)
            else
                print("${winner.carName}, ")
        }
    }
}