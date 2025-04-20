package racingcar

import camp.nextstep.edu.missionutils.Console

class Input(private val validator: Validator) {

    fun enterCarNames(): Set<Car> {
        val carNames = Console.readLine().split(COMMA)
        validator.validateEachName(carNames, CAR_NAME_LIMIT)
        return carNames.toCars()
    }

    fun enterRoundCount(): Int {
        val roundCount = Console.readLine()
        return validator.validateStringToInt(roundCount)
    }

    private fun List<String>.toCars() = map { Car(it) }.toSet()

    companion object {
        private const val COMMA = ","
        private const val CAR_NAME_LIMIT = 5
    }
}
