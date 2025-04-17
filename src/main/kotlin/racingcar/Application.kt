package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("Enter the names of the cars (comma-separated):")
    val carNamesInput = Console.readLine()
    val carNames = InputHandler.parseCarNames(carNamesInput)

    println("How many rounds will be played?")
    val roundsInput = Console.readLine()
    val rounds = InputHandler.parseRounds(roundsInput)
    println(rounds)
}





