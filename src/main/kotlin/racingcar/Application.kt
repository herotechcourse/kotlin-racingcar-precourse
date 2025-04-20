package racingcar

import racingcar.domain.*

fun main() {
        println("Enter the names of the cars (comma-separated):")
        val rawCarNames = readLine()
            ?.split(",")
            ?.map { it.trim() }
            ?: throw IllegalArgumentException("Car names cannot be empty.")
        val cars = Cars( rawCarNames.map { Car(it) })

        println("Enter the number of rounds:")
        val roundCount = readLine()
            ?.toIntOrNull()
            ?.takeIf { it > 0 }
            ?: throw IllegalArgumentException("Number of rounds must be a positive number.")

        val results = race(cars, roundCount)
        val winnersCarNames = results
            .getWinners().getCarNames()
        println("Race Results\n"+results.toString()+"Winners : ${winnersCarNames.joinToString(", ")}")
}

fun race(cars: Cars, roundCount: Int): Rounds {
    val roundsTemp = mutableListOf<Round>()
    for (roundIndex in 1..roundCount) {
        cars.moveRandomly()
        val round = cars.createRound(roundIndex)
        roundsTemp.add(round)
    }
    return Rounds(roundsTemp)
}
