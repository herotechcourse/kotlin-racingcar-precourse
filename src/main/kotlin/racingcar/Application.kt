package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("Enter the names of the cars (comma-separated):")
    val carNamesInput = Console.readLine()
    val validator = InputHandler()
    val carNames = validator.parseCarNames(carNamesInput)
    println("How many rounds will be played?")
    val roundsInput = Console.readLine()
    val rounds = validator.parseRounds(roundsInput)
    val game = RacingGame(carNames, rounds)
    game.run()
}





