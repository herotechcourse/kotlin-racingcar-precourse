package racingcar

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