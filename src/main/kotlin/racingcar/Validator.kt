package racingcar

/**
 * Validates input data for the racing game, including car names and the number of rounds.
 */
class Validator {

    /**
     * Validates the list of car names.
     *
     * @param carsName the list of car names to validate
     */
    fun validateCarsName(carsName: List<String>) {
        validateCarsNameLength(carsName)
        validateNumberOfCar(carsName)
        validateDuplicateCarNames(carsName)
    }

    /**
     * Validates the round input.
     *
     * @param round the round input to validate
     */
    fun validateRound(round: String) {
        validateRoundType(round)
        validateNumberOfRound(round.toInt())
    }

    /**
     * Validates that each car name is between 1 and 5 characters long.
     *
     * @param carsName the list of car names to validate
     * @throws IllegalArgumentException if any car name is empty or longer than 5 characters
     */
    private fun validateCarsNameLength(carsName: List<String>) {
        carsName.forEach { name ->
            if (name.isEmpty() || name.length > 5) {
                throw IllegalArgumentException("Each car name must contain 1 to 5 characters.")
            }
        }
    }

    /**
     * Validates that there are at least two car names.
     *
     * @param carsName the list of car names to validate
     * @throws IllegalArgumentException if there are fewer than two car names
     */
    private fun validateNumberOfCar(carsName: List<String>) {
        if (carsName.size < 2) {
            throw IllegalArgumentException("At least two car names must be provided to start the race.")
        }
    }

    /**
     * Validates that all car names are unique.
     *
     * @param carNames the list of car names to validate
     * @throws IllegalArgumentException if any car names are duplicated
     */
    private fun validateDuplicateCarNames(carNames: List<String>) {
        if (carNames.toSet().size != carNames.size) {
            throw IllegalArgumentException("Car names must be unique to start the race.")
        }
    }

    /**
     * Validates that the round input is a valid integer.
     *
     * @param round the round input to validate
     * @throws IllegalArgumentException if the round input is not a valid number
     */
    private fun validateRoundType(round: String) {
        if (round.toIntOrNull() == null) {
            throw IllegalArgumentException("Round must be a number.")
        }
    }

    /**
     * Validates that the number of rounds is at least 1.
     *
     * @param round the round input to validate
     * @throws IllegalArgumentException if the number of rounds is less than 1
     */
    private fun validateNumberOfRound(round: Int) {
        if (round < 1) {
            throw IllegalArgumentException("Number of rounds must be at least 1 to start the race.")
        }
    }
}