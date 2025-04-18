package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.validation.validateCarNames
import racingcar.validation.validateTheNumberOfRounds

class InputView {
    // TO-DO: Refactor inputCarNames -> getCarNamesInput
    fun inputCarNames(): List<String> {
        println("Enter the names of the cars (comma-separated):")
        val carNamesInput = Console.readLine()
        val splitCarNames = carNamesInput.split(",").map { it.trim() }

        if (validateCarNames(splitCarNames)) {
            return splitCarNames
        }

        return emptyList()
    }

    fun inputTheNumberOfRounds(): Int {
        println("How many rounds will be played?")
        val numberOfRoundsInput: String = Console.readLine()

        if (validateTheNumberOfRounds(numberOfRoundsInput)) {
            return numberOfRoundsInput.toInt()
        }

        // TO-DO: Refactor
        return 0
    }
}