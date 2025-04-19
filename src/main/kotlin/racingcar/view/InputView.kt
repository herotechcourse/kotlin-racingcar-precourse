package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.util.Validator

object InputView {
    fun readCarNames(): List<String> {
        println("Input car names separated by commas:")
        val input = Console.readLine()
        val names = input.split(",").map { it.trim() }
        Validator.validateCarNames(names)
        return names
    }

    fun readRoundCount(): Int {
        println("Input the number of attempts:")
        val input = Console.readLine()
        return Validator.validateRoundCount(input)
    }
}