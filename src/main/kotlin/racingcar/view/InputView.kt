package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.validation.validateCarNames
import racingcar.validation.validateRacingRounds


object InputView {
    private const val CAR_NAMES_INPUT = "Enter the names of the cars (comma-separated):"
    private const val ROUNDS_INPUT = "How many rounds will be played?"

    fun getCarNamesInput(): List<String> {
        println(CAR_NAMES_INPUT)
        val carNamesInput = Console.readLine()
        val splitCarNames = carNamesInput.split(",").map { it.trim() }

        if (validateCarNames(splitCarNames)) {
            return splitCarNames
        }

        return emptyList()
    }

    fun getRacingRoundsInput(): Int {
        println(ROUNDS_INPUT)
        val racingRoundInput: String = Console.readLine()

        if (validateRacingRounds(racingRoundInput)) {
            return racingRoundInput.toInt()
        }

        // TO-DO: Refactor
        return 0
    }
}