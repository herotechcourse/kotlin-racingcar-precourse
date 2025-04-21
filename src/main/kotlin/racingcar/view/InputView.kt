package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.view.Validator.validateCarNames

object InputView {
    fun readCarNames(): List<String> {
        println("Enter the names of the cars (comma-separated):")
        val input = Console.readLine()
        val names = input.split(",").map { it.trim() }
        validateCarNames(names)
        return names
    }

    fun readRound(): Int {
        println("How many rounds will be played?")
        val input = Console.readLine()
        val round = input.toIntOrNull()
        require(round != null && round > 0) { "Number of rounds must be a positive integer" }
        return round
    }
}
