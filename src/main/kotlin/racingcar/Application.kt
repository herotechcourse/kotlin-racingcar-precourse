package racingcar

fun main() {
    val names = InputView.readNames()
    val rounds = InputView.readRounds()

    val cars = Cars(names.map { Car(it) })
    val game = RacingGame(cars, rounds)

    game.play().forEach { state ->
        OutputView.printRound(state)
    }

    val winners = cars.findWinners()
    OutputView.printWinners(winners)
}

