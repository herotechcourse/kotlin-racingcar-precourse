package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.utils.Validator

object InputView {
    fun getCarNames(): List<String> {
        println("Enter the names of the cars (comma-separated):")
        val input = Console.readLine()
        return Validator.validateCarNames(input)
    }

    fun getRounds(): Int {
        println("How many rounds will be played?")
        val input = Console.readLine()
        return Validator.validateRounds(input)
    }
}