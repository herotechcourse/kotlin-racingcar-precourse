package racingcar

import camp.nextstep.edu.missionutils.Console

object InputManager {
    private const val MIN_ROUNDS_NUM = 1
    private const val MAX_ROUNDS_NUM = 10000

    private fun validateSetOfCarNames (carNames: List<String>) : Boolean {
        // split and check valid cars names
        for (name in carNames) {
            if (name.length > 5 || name.isBlank())
                return false
        }
        return true
    }

    fun carNames(): List<String> {
        // input car names
        println("Enter the names of the cars (comma-separated):")
        val carNamesInputVal: String = Console.readLine()

        val setOfCarName: List<String> = carNamesInputVal.split(',')
        if (!validateSetOfCarNames(setOfCarName))
            throw IllegalArgumentException("The name is longer than 5 characters or empty.")

        return setOfCarName
    }

    private fun validateRoundNumAndToInt(input: String): Int {
        val round = input.toIntOrNull() ?: return -1
        return if (round in MIN_ROUNDS_NUM..MAX_ROUNDS_NUM) round else 0
    }

    fun rounds(): Int {
        println("How many rounds will be played?")
        val roundInputVal = Console.readLine()

        val rounds = validateRoundNumAndToInt(roundInputVal)
        if (rounds == -1) {
            throw IllegalArgumentException("Input is not a number")
        }
        if (rounds == 0) {
            throw IllegalArgumentException("Input is out of range (1 ~ 10000)")
        }

        return rounds
    }
}