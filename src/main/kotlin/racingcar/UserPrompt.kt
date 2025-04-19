package racingcar

import camp.nextstep.edu.missionutils.Console

object UserPrompt {
    fun promptCarNames(): List<Car> {
        println("Names of the cars (comma-separated):")
        val cars = Console.readLine().split(",").map {
            require(it.trim().length <= 5) { "Each name should be up to 5 characters" }
            val car = Car(it.trim())
            car
        }
        return cars
    }

    fun promptRounds(): Int {
        println("How many rounds will be played?")
        val rounds = Console.readLine().toIntOrNull()
        require(rounds != null && rounds > 0) { "The number of rounds should be a valid number" }
        return rounds
    }
}