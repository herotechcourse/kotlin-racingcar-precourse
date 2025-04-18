package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.validation.validateCarNames
import racingcar.validation.validateRacingRounds

class InputView {
    fun getCarNamesInput(): List<String> {
        // TO-DO: to constant
        println("Enter the names of the cars (comma-separated):")
        val carNamesInput = Console.readLine()
        val splitCarNames = carNamesInput.split(",").map { it.trim() }

        if (validateCarNames(splitCarNames)) {
            return splitCarNames
        }

        return emptyList()
    }

    fun getRacingRoundsInput(): Int {
        // TO-DO: to constant
        println("How many rounds will be played?")
        val racingRoundInput: String = Console.readLine()

        if (validateRacingRounds(racingRoundInput)) {
            return racingRoundInput.toInt()
        }

        // TO-DO: Refactor
        return 0
    }
}