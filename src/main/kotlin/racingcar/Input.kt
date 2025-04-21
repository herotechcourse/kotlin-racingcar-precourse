package racingcar

import camp.nextstep.edu.missionutils.Console

class InputParser {
    fun getCarNames(): List<String> {
        println("Enter the names of the cars (comma-separated):")
        val inputCar = Console.readLine()
        // Convert comma-separated string into clean list
        val carNames = inputCar.split(",").map { it.trim() }

        validateCarNames(carNames)

        return carNames
    }

    fun validateCarNames(carNames: List<String>) {
        if (carNames.isEmpty()) {
            throw IllegalArgumentException("Car names cannot be empty")
        }

        carNames.forEach { name ->
            if (name.isEmpty()) {
                throw IllegalArgumentException("Car names cannot be empty")
            }

            if (name.length > 5) {
                throw IllegalArgumentException("Car names cannot exceed 5 characters")
            }

        }

        if (carNames.size != carNames.toSet().size){
            throw IllegalArgumentException("Car names must be unique")
        }
    }

    fun getRounds(): Int {
        println("How many rounds will be played?")
        val inputRounds = Console.readLine()

        return try {
            // Convert string to int
            val rounds = inputRounds.toInt()
            if (rounds <= 0) {
                throw IllegalArgumentException("Number of rounds must be positive")
            }
            rounds
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("Number of rounds must be a valid integer")
        }
    }
}