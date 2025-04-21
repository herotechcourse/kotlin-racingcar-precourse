package racingcar

fun main() {
    val names = InputView.readCarNames()
    val cars = names.map { Car(it) }
    val round = InputView.readRoundCount()
    println("\nRace Results")
    val game = RacingGame(cars)
    game.play(round)

    val winners = game.getWinners()
    println("Winners : ${winners.joinToString(", ")}")
}

