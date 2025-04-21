package racingcar.view

import camp.nextstep.edu.missionutils.Console
import java.util.NoSuchElementException

class InputView {
    fun readCarNames(): List<String> {
        println("Enter the names of the cars (comma-separated):")
        val input = try {
            Console.readLine()
        } catch (e: NoSuchElementException) {
            throw IllegalArgumentException("At least two car names must be provided its a race!")
        }
        
        val carNames = input.split(",").map { it.trim() }
        validateCarNames(carNames)
        return carNames
    }

    fun readRoundCount(): Int {
        println("How many rounds will be played?")
        val input = try {
            Console.readLine()
        } catch (e: NoSuchElementException) {
            throw IllegalArgumentException("Round count must be a valid integer")
        }
        
        val roundCount = try {
            input.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("Round count must be a valid integer")
        }
        validateRoundCount(roundCount)
        return roundCount
    }

    private fun validateCarNames(carNames: List<String>) {
        require(carNames.isNotEmpty()) { "At least one car name must be provided" }
        require(carNames.size >= 2) { "At least two car names must be provided its a race!" }
        
        carNames.forEach { name ->
            require(name.isNotEmpty()) { "Car name cannot be empty" }
            require(name.length <= MAX_NAME_LENGTH) { "Car name cannot have more then $MAX_NAME_LENGTH characters" }
        }
    }

    private fun validateRoundCount(roundCount: Int) {
        require(roundCount > 0) { "Round count must be positive" }
    }

    companion object {
        private const val MAX_NAME_LENGTH = 5
    }
}
