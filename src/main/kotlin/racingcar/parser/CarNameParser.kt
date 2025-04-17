package racingcar.parser

import racingcar.domain.CarName

class CarNameParser {
    fun parse(carNames: String): List<CarName> {
        require(carNames.contains(",")) { ERROR_MUST_BE_COMMA_SEPARATED }

        val names = carNames.split(",")
        require(names.all { it.isNotBlank() }) { ERROR_BLANK_NAME }

        return names.map { CarName.from(it) }
    }

    companion object {
        const val ERROR_MUST_BE_COMMA_SEPARATED = "[ERROR] Names of the cars must be comma-separated"
        const val ERROR_BLANK_NAME = "[ERROR] Car name cannot be blank"
    }
}
