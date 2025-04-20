package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("Enter the names of the cars (comma-separated):")
    val carInput = Console.readLine()
    val carNames = InputValidator.validateCarNames(carInput)

    println("How many rounds will be played?")
    val roundInput = Console.readLine()
    val roundCount = InputValidator.validateRoundCount(roundInput)

    val cars = carNames.map { Car(it) }
    val game = RacingGame(cars)
    game.runRounds(roundCount)
}
