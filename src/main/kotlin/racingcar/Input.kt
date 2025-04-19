package racingcar

import camp.nextstep.edu.missionutils.Console

class Input(private val validator: Validator) {

    fun enterCarNames(): List<String> {
        val carNames = Console.readLine()
        return carNames
            .splitWithDelimiter(COMMA, CAR_NAME_LIMIT)
    }

    private fun String.splitWithDelimiter(delimiter: String, limit: Int): List<String> {
        return this
            .split(delimiter)
            .onEach {
                validator.validateName(it, limit)
            }
    }

    companion object {
        private const val COMMA = ","
        private const val CAR_NAME_LIMIT = 5
    }
}
