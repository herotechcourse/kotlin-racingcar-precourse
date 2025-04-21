package racingcar.input

import camp.nextstep.edu.missionutils.Console
import racingcar.utils.Validator

class InputView {

    fun readCarNames() : List<String> {
        println("Enter the names of the cars (comma-separated): ")
        val input = Console.readLine()
        val carNames = input.split(",").map { it.trim() }
        Validator.carValidate(carNames)
        return carNames
    }

    fun readRounds(): Int {
        println("How many rounds will be played?")
        val input = Console.readLine()
        Validator.roundValidate(input)
        println()
        println("Race Results")
        return input.toInt()
    }
}