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
    
    /**
     * Validates car names
     * @param carNames List of car names
     * @throws IllegalArgumentException when car names are invalid
     */
    private fun validateCarNames(carNames: List<String>) {
        if (carNames.isEmpty()) {
            throw IllegalArgumentException("Car names cannot be empty.")
        }
        
        for (name in carNames) {
            if (name.isEmpty()) {
                throw IllegalArgumentException("Car name cannot be empty.")
            }
            if (name.length > 5) {
                throw IllegalArgumentException("Car name cannot exceed 5 characters: $name")
            }
        }
    }
    
    /**
     * Validates number of rounds
     * @param input User input for rounds
     * @return Validated round number
     * @throws IllegalArgumentException when round number is invalid
     */
    private fun validateRounds(input: String): Int {
        return try {
            val rounds = input.toInt()
            if (rounds <= 0) {
                throw IllegalArgumentException("Rounds must be a positive number.")
            }
            rounds
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("Rounds must be a valid number.")
        }
    }
} 