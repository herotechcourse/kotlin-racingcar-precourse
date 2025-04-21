package racingcar.validation

import racingcar.model.Car

class CarNameValidator {

    fun validateCarNames(carNames: List<String>) {
        if (carNames.isEmpty()) {
            throw IllegalArgumentException("At least one name required")
        }

        if (carNames.size != carNames.toSet().size) {
            throw IllegalArgumentException("Car names must be unique")
        }

        for (name in carNames) {
            val trimmedName = name.trim()
            if (trimmedName.isEmpty()) {
                throw IllegalArgumentException("Car name cannot be empty")
            }
            if (trimmedName.length > 5) {
                throw IllegalArgumentException("Each name allowed up to 5 characters: '$trimmedName'")
            }
        }
    }
}