package racingcar.domain

class RoundParser {
    fun parse(round: String): Int {
        return round.toIntOrNull() ?: throw IllegalArgumentException(NOT_A_NUMBER)
    }

    companion object {
        const val NOT_A_NUMBER = "[ERROR] Round must be a number."
    }
}
