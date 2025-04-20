package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.validation.validateCarNames
import racingcar.validation.validateRacingRounds

object InputView {
    private const val CAR_NAMES_INPUT = "Enter the names of the cars (comma-separated):"
    private const val ROUNDS_INPUT = "How many rounds will be played?"
    private const val CAR_NAME_DELIMITER = ","

    fun getCarNamesInput(): List<String> {
        println(CAR_NAMES_INPUT)
        val carNamesInput = Console.readLine()
        val splitCarNames = carNamesInput.split(CAR_NAME_DELIMITER).map { it.trim() }

        validateCarNames(splitCarNames)
        return splitCarNames
    }

    fun getRacingRoundsInput(): Int {
        println(ROUNDS_INPUT)
        val racingRoundInput: String = Console.readLine()

        validateRacingRounds(racingRoundInput)
        return racingRoundInput.toInt()
    }
}

