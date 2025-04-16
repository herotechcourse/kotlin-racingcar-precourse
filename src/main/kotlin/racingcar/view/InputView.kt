package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.validation.validateCarNames

class InputView {
    fun inputCarNames(): List<String> {
        println("Enter the names of the cars (comma-separated):")
        val carNamesInput = Console.readLine()
        val splitCarNames = carNamesInput.split(",").map { it.trim() }

        if (validateCarNames(splitCarNames)) {
            return splitCarNames
        }

        return emptyList()
    }
}