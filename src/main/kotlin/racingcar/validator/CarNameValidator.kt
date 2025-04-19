package racingcar.validator

object CarNamesValidator {

    fun validate(carNames: List<String>) {
        requireMinimumCarCount(carNames)
        requireNoBlankNames(carNames)
        requireNoDuplicateNames(carNames)
        requireNameLengthLimit(carNames)
    }

    private fun requireMinimumCarCount(carNames: List<String>) {
        require(carNames.size >= 2) {
            "At least two cars are required."
        }
    }

    private fun requireNoBlankNames(carNames: List<String>) {
        require(carNames.none { it.isBlank() }) {
            "Car names must not be empty or blank."
        }
    }

    private fun requireNoDuplicateNames(carNames: List<String>) {
        require(carNames.distinct().size == carNames.size) {
            "Car names must not be duplicated."
        }
    }

    private fun requireNameLengthLimit(carNames: List<String>) {
        require(carNames.all { it.length <= 5 }) {
            "Car names must not exceed 5 characters."
        }
    }
}