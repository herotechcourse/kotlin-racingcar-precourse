package racingcar

const val MAX_LIMIT = 5

class InputValidator(val carInput: String, val roundInput: Int) {
    private val carString = carInput
    private val rounds = roundInput

    fun validateCarNames(): List<String>{
        val carNames = carString.split(",").map { it.trim() }.filter { it.isNotEmpty() }?: emptyList()
        // Check if the list is empty – there should be at least one car name provided
        if (carNames.isEmpty()) {
            throw IllegalArgumentException("At least one car name must be provided")
        }
        // Check if any car name contains more than 5 characters
        if (carNames.any { it.length > MAX_LIMIT }) {
            throw IllegalArgumentException("Car names must not exceed 5 characters")
        }
        // Check for duplicate car names – all names should be unique
        if (carNames.size != carNames.toSet().size) {
            throw IllegalArgumentException("Each car must have a unique name")
        }
        return carNames
    }

    fun validateRound(): Int {
        // Check if the input is a non-negative integer or not
        if (rounds < 1 ){
            throw IllegalArgumentException("Number of rounds must be a non-negative integer")
        }
        return rounds
    }
}
