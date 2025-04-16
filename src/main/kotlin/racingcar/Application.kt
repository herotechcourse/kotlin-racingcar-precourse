package racingcar

import racingcar.validation.CarNameValidator

fun main() {
    try {
        // Car names list will be provided by other feature [feature/car-name-input]. Hence, hardcoding with sample data
        val carNames = listOf("bmw", "", "audi")

        // Validate the list of car names
        CarNameValidator.validateAll(carNames)

        println("Valid car names: $carNames")
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }
}
