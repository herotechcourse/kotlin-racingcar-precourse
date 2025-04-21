package racingcar

class RacingGame(private val cars: List<Car>, private val tryCount: Int) {

    fun runRace() {
        OutputView.printRoundResultHeader()
        repeat(tryCount) {
            playRound()
            OutputView.printRoundStatus(cars)
        }
        announceWinners()
    }

    private fun playRound() {
        cars.forEach { car ->
            car.move()
        }
    }

    private fun findWinners(): List<String> {
        val maxPosition = cars.maxOfOrNull { it.position } ?: 0
        return cars.filter { it.position == maxPosition }
            .map { it.name }
    }

    private fun announceWinners() {
        val winners = findWinners()
        OutputView.printWinners(winners)
    }
}
