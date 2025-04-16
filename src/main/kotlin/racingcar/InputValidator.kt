package racingcar

class InputValidator {
    companion object {
        private const val MAX_NAME_LENGTH = 5

        fun validateCarNames(carNames: List<String>) {
            if (carNames.isEmpty()) {
                throw IllegalArgumentException("Car names cannot be empty.")
            }

            carNames.forEach { name ->
                if (name.isEmpty()) {
                    throw IllegalArgumentException("Car name cannot be empty.")
                }

                if (name.length > MAX_NAME_LENGTH) {
                    throw IllegalArgumentException("Car name cannot exceed 5 characters.")
                }
            }
        }

        fun validateRounds(rounds: String): Int {
            return try {
                val roundNumber = rounds.toInt()
                if (roundNumber <= 0) {
                    throw IllegalArgumentException("Number of rounds must be positive.")
                }
                roundNumber
            } catch (e: NumberFormatException) {
                throw IllegalArgumentException("Number of rounds must be a valid integer.")
            }
        }
    }
}