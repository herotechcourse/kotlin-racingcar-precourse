package racingcar.parser

class CarNameParser {
    private fun validateInputCarNames(input: String): List<String> {
        val trimmedInput = input.trim()

        if (trimmedInput.isEmpty()) {
            throw IllegalArgumentException("Car names cannot be empty")
        }
        if (trimmedInput.contains(" ") && !trimmedInput.contains(",")) {
            throw IllegalArgumentException("Multiple car names must be separated by commas, not spaces")
        }

        return trimmedInput.split(",").map { it.trim() }
    }

    private fun validateCarNames(carNames: List<String>): List<String> {
        val uniqueCarNames = mutableSetOf<String>()

        carNames.forEach { carName ->
            if (carName.isEmpty()) throw IllegalArgumentException("Car name cannot be blank")
            if (carName.length > MAX_CAR_NAME_LENGTH) throw IllegalArgumentException("Car name cannot exceed $MAX_CAR_NAME_LENGTH characters")
            if (!uniqueCarNames.add(carName)) throw IllegalArgumentException(
                "Duplicated car name : $carName"
            )
        }
        return carNames
    }

    fun parse(input: String): List<String> {
        return validateCarNames(validateInputCarNames(input))
    }

    companion object{
        const val MAX_CAR_NAME_LENGTH = 5
    }
}