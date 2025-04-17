package racingcar

fun main() {
    val carNames = InputValidator.getValidCarNames()
    val rounds = InputValidator.getValidRoundsNumber()
    val cars = carNames.map { Car(it) }

    val game = Game(cars, rounds)
    game.start()

    val winners = game.getWinner()
    OutputFormatter.formatFinalWinners(winners)
}
