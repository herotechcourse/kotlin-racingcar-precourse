package racingcar

fun main() {
    val carNames = InputParser.readCarNames()
    val rounds = InputParser.readTotalRounds()

    val cars = carNames.map { Car(it) }
    GameLogic.startRace(cars, rounds)

    OutputHandler.printWinners(cars)
}
