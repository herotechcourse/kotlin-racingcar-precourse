package racingcar.domain

import racingcar.domain.ErrorMessages.CARS_MINIMUM_COUNT
import racingcar.domain.ErrorMessages.CARS_NO_DUPLICATES

class Cars(names: List<String>) {
    val cars: List<Car>

    init {
        validateSize(names)
        validateDuplicates(names)
        cars = names.map { Car(it) }
    }

    /**
     * Validates that the input list contains at least 2 names.
     * IllegalArgumentException if fewer than 2 names are provided
     */
    private fun validateSize(names: List<String>) {
        if (names.size < 2) {
            throw IllegalArgumentException(CARS_MINIMUM_COUNT)
        }
    }

    /**
     * Validates that there are no duplicate names in the list,
     * ignoring case differences.
     * IllegalArgumentException if any duplicate names are found
     */
    private fun validateDuplicates(names: List<String>) {
        val lowercaseNames = names.map { it.lowercase() }

        if (lowercaseNames.size != lowercaseNames.distinct().size) {
            throw IllegalArgumentException(CARS_NO_DUPLICATES)
        }
    }
}
