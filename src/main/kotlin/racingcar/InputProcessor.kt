package racingcar

class InputProcessor {
    fun getValidatedCarNames(userInput: String): List<String> {
        if (userInput.isEmpty()) {
            throw IllegalArgumentException("Car must have a name")
        }

        val carNames = userInput.split(",").map { it.trim() }

        for (name in carNames) {
            if (name.length > 5) {
                throw IllegalArgumentException("Car name '$name' cannot exceed 5 characters")
            }
        }

        return carNames.toSet().toList()
    }

    fun getValidatedNumberOfRounds(input: String): Int {
        if (input.isEmpty()) {
            throw IllegalArgumentException("Number of round must have a numerical value")
        }
        return try {
            val numberOfRounds = input.toInt()
            if (numberOfRounds <= 0) {
                throw IllegalArgumentException("Numbers of rounds must be greater than 0")
            }
            numberOfRounds
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("Invalid input: '$input' is not a valid number for rounds")
        }
    }
}