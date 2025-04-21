package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.util.Validator

object InputView {
    fun readCarNames(): List<String> {
        println("Enter the names of the cars (comma-separated):")
        val input = Console.readLine()
        val names = input.split(",").map { name -> name.trim() }
        Validator.validateCarNames(names)
        return names
    }

    fun readRoundCount(): Int {
        println("How many rounds will be played?")
        val input = Console.readLine()
        return Validator.validateRoundCount(input)
    }
}