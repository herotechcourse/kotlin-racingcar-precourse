package racingcar.util

class StringParser private constructor() {

    companion object {
        private const val INVALID_NUMBER_ERROR = "[ERROR] Input value must be a number."

        fun parseByDelimiter(input: String, delimiter: String): List<String> {
            return input.split(delimiter)
        }

        fun parseToInt(input: String): Int {
            val round = input.toIntOrNull()
            require(round != null) { INVALID_NUMBER_ERROR }
            return round
        }
    }
}
