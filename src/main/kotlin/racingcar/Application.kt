package racingcar

fun main() {
    Output.printCarNameInputMessage()
    val carNames = Input.readNamesOfTheCars()

    Output.printRoundInputMessage()
    val round = Input.readNumberOfRounds()

    var cars = carNames.map { Car(it) }

    Output.printRaceStartMessage()
    repeat(round) {
        cars = Game.playOneRound(cars)
        Output.printProgress(cars)
    }

    val winners = Game.getWinners(cars)
    Output.printWinners(winners)
}
