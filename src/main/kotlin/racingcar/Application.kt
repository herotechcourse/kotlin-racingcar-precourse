package racingcar

import camp.nextstep.edu.missionutils.Console

class Application {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Application().inputCarNames()
        }
    }

    private fun inputCarNames(): List<String> {
        println("Enter names of the cars (comma-separated): ")
        val input = Console.readLine()
        val carNames = input.split(",").map { it.trim() }
        validateCarNames(carNames)
        println(carNames)
        return carNames
    }

    private fun validateCarNames(carNames: List<String>) {
        if (carNames.isEmpty()) {
            throw IllegalArgumentException("Car names cannot be empty")
        }
        for (name in carNames) {
            if (name.isEmpty()) {
                throw IllegalArgumentException("Car names cannot be empty")
            }
            if (name.length > 5) {
                throw IllegalArgumentException("Car name cannot exceed 5 characters")
            }
        }
    }
}
