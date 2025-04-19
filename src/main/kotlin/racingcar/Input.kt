package racingcar

import camp.nextstep.edu.missionutils.Console

class Input(private val validator: Validator) {

    fun enterCarNames(): MutableMap<String, Int> {
        val carNames = Console.readLine()
        return carNames
            .splitWithDelimiter(COMMA, CAR_NAME_LIMIT)
            .convertListToMap()
    }

    private fun String.splitWithDelimiter(delimiter: String, limit: Int): List<String> {
        return this
            .split(delimiter)
            .onEach {
                validator.validateName(it, limit)
            }
    }

    private fun List<String>.convertListToMap(): MutableMap<String, Int> {
        return this
            .associateBy({ key -> key }, { value -> 0 })
            .toMutableMap()
    }

    companion object {
        private const val COMMA = ","
        private const val CAR_NAME_LIMIT = 5
    }
}
