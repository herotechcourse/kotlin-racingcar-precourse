package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("Enter the names of the cars (comma-separated):")
    val carsStr = Console.readLine() ?: ""
    val carList =
        carsStr
            .split(',')
            .map { it.trim() }
            .filter { it.isNotEmpty() }
            .toSet()
    if (carList.isEmpty()) {
        throw IllegalArgumentException()
    }

    val cars =

        carList.map { carName ->
            if (Car.isValidName(carName)) {
                Car(carName)
            } else {
                throw IllegalArgumentException()
            }
        }

    println("How many rounds will be played?")
    val roundStr = Console.readLine()
    val rounds = roundStr?.toIntOrNull()
    if (rounds == null || rounds <= 0) {
        throw IllegalArgumentException()
    }

    val race = Race(rounds, cars)
    race.run()
    race.displayWinners()
}
