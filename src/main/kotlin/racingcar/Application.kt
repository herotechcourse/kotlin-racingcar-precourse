package racingcar

fun main() {
    try {
        val carNames = InputHandler.readCarNames()
        val numberOfRounds = InputHandler.readNumberOfRounds()

        val cars = Cars.fromNames(carNames)

        OutputView.printRaceStart()
        repeat(numberOfRounds) {
            cars.moveAll()
            OutputView.printRound(cars)
        }

        val winners = cars.getWinners()
        OutputView.printWinners(winners)

    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }
}
