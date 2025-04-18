package view

import camp.nextstep.edu.missionutils.Console
import racingcar.model.Car

class InputView {
    fun readCarNames(): List<String> {
        println("Enter the names of the cars (comma-separated):")
        val input = Console.readLine()

        val carNames = input.split(",")

        carNames.forEach { name ->
            require(name.isNotBlank() && name.length <= Car.MAX_NAME_LENGTH) {
                "Car must have a name, and names cannot exceed 5 characters."
            }
        }

        return carNames
    }

    fun readNumberOfRounds(): Int {
        println("How many rounds will be played?")
        val input = Console.readLine()

        val rounds = try {
            input.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("Please enter a valid number.")
        }

        require(rounds > 0) { "Rounds should be positive integer." }

        return rounds
    }
}