package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    val carNames = InputView.readCarNames()
    val numberOfRounds = InputView.readNumberOfRounds()

    val race = Race(carNames.map { Car(it) })

    println("\nRace Results")
    repeat(numberOfRounds) {
        race.moveAllCars()
        race.printStatus()
    }

    val winners = race.findWinners()
    println("Winners : ${winners.joinToString(", ")}")
}
