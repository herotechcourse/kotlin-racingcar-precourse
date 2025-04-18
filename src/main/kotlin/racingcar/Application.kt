package racingcar

import camp.nextstep.edu.missionutils.Console

fun removeDuplicatesIgnoreCase(list: List<String>): List<String> {
    val seen = mutableSetOf<String>()
    return list.filter { item ->
        val lower = item.lowercase()
        if (lower !in seen) {
            seen.add(lower)
            true
        } else {
            false
        }
    }
}

fun main() {
    println("Enter the names of the cars (comma-separated):")
    val carsStr = Console.readLine() ?: ""
    val carList =
        carsStr
            .split(',')
            .map { it.trim() }
            .filter { it.isNotEmpty() }
    val carNames = removeDuplicatesIgnoreCase(carList)
    if (carNames.isEmpty()) {
        throw IllegalArgumentException()
    }

    val cars =
        carNames.map { carName ->
            if (Car.isValidName(carName)) {
                Car(carName)
            } else {
                throw IllegalArgumentException()
            }
        }

    println("How many rounds will be played?")
    val roundStr = Console.readLine()
    val rounds = roundStr?.toLongOrNull()
    if (rounds == null || rounds < 0) {
        throw IllegalArgumentException()
    }

    val race = Race(rounds, cars)
    race.run()
    race.displayWinners()
}
