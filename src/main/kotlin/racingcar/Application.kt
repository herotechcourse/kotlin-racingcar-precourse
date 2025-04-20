package racingcar

import camp.nextstep.edu.missionutils.Console

fun parseNames(input: String): List<String> {
    return input.split(",").map { it.trim() }
}

fun validateNames(names: List<String>): Boolean {
    return names.all { it.isNotBlank() && it.length <= 5 }
}

fun validateRounds(rounds: Int?): Boolean {
    return !(rounds == null || rounds <= 0)
}

fun main() {
    println("Enter the names of the cars (comma-separated):")
    val namesInput = Console.readLine()
    val names = parseNames(namesInput)

    if (!validateNames(names)) {
        throw IllegalArgumentException("Each car name cannot exceed 5 characters.")
    }

    println("How many rounds will be played?")
    val rounds = Console.readLine()?.toIntOrNull()

    if (!validateRounds(rounds)) {
        throw IllegalArgumentException("Rounds cannot be less than 1")
    }

    val cars = names.map { Car(it) }
    val race = Race(cars, rounds!!)

    race.start()
    race.displayWinners()

}
