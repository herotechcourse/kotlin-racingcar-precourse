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
}