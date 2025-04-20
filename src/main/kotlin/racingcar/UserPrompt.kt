package racingcar

import camp.nextstep.edu.missionutils.Console

object UserPrompt {
    fun validateCarName(name: String) {
        require(name.length <= 5) { "Each name should be up to 5 characters" }
    }

    fun parseRounds(input: String): Int {
        val rounds = input.toIntOrNull()
        require(rounds != null && rounds > 0) { "The number of rounds should be a valid number" }
        return rounds
    }

    fun promptCarNames(): List<Car> {
        println("Names of the cars (comma-separated):")
        val cars = Console.readLine().split(",").map {
            validateCarName(it.trim())
            Car(name = it.trim())
        }
        return cars
    }

    fun promptRounds(): Int {
        println("How many rounds will be played?")
        val input = Console.readLine()
        return parseRounds(input)
    }
}