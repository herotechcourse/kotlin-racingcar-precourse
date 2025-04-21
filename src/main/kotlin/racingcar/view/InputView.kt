package racingcar.view

import camp.nextstep.edu.missionutils.Console

/**
 * Handles user input
 */
class InputView {
    
    /**
     * Reads car names
     * @return List of car names
     * @throws IllegalArgumentException when invalid car names are input
     */
    fun readCarNames(): List<String> {
        println("Enter the names of the cars (comma-separated):")
        val input = Console.readLine()
        validateInput(input, "Car names cannot be empty")
        
        val carNames = input.split(",").map { it.trim() }
        validateCarNames(carNames)
        return carNames
    }
    
    /**
     * Reads number of rounds
     * @return Number of rounds
     * @throws IllegalArgumentException when invalid round number is input
     */
    fun readRounds(): Int {
        println("How many rounds will be played?")
        val input = Console.readLine()
        return validateRounds(input)
    }
    
    private fun validateInput(input: String, message: String) {
        if (input.isBlank()) {
            throw IllegalArgumentException(message)
        }
    }
    
    /**
     * Validates car names
     * @param carNames List of car names
     * @throws IllegalArgumentException when car names are invalid
     */
    internal fun validateCarNames(carNames: List<String>) {
        if (carNames.isEmpty()) {
            throw IllegalArgumentException("At least one car name must be provided")
        }
        
        carNames.forEach { name ->
            when {
                name.isBlank() -> throw IllegalArgumentException("Car name cannot be empty")
                name.length > 5 -> throw IllegalArgumentException("Car name cannot exceed 5 characters: $name")
                name.contains(" ") -> throw IllegalArgumentException("Car name cannot contain spaces: $name")
            }
        }
    }
    
    /**
     * Validates number of rounds
     * @param input User input for rounds
     * @return Validated round number
     * @throws IllegalArgumentException when round number is invalid
     */
    internal fun validateRounds(input: String): Int {
        try {
            val rounds = input.toInt()
            if (rounds <= 0) throw IllegalArgumentException("Number of rounds must be positive")
            return rounds
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("Invalid round number: must be a positive integer")
        }
    }
} 