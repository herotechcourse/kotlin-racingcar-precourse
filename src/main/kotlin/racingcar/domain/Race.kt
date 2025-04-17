package racingcar.domain

class Race(private val cars: List<Car>, private val rounds: Int) {
    fun run(): List<Car> {
        repeat(rounds) {
            executeRound()
        }
        return determineWinners()
    }

    private fun executeRound() {
        // TODO
    }

    private fun determineWinners(): List<Car> {
        // TODO
        return emptyList()
    }
}