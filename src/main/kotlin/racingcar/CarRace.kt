package racingcar

import camp.nextstep.edu.missionutils.Console
import org.assertj.core.util.Strings

class CarRace(private val cars: List<Car>, private val rounds: Int) {
    //Just for testing
    fun printInfo() {
        println("cars: $cars, rounds: $rounds")
    }
    companion object {
        fun initializeRace(): CarRace {
            val cars = getCars()
            val rounds = getRounds()

            return CarRace(cars, rounds)
        }
    }
}

fun getCars(): List<Car> {
    var input: String

    while (true) {
        println("Enter the names of the cars (comma-separated):")
        input = Console.readLine() ?: continue
        if (input != "") break
    }

    val names = splitCarNames(input)
    validateNamesSize(names)
    val cars = names.map { Car(it) }

    return cars
}

fun splitCarNames(userInput: String): List<String> {
    val names: List<String>

    if (userInput.contains(',')) {
        names = userInput.split(',').map { it.trim() }
    } else {
        names = userInput.trim().split(' ')
        if (names.size > 1) throw IllegalArgumentException("Names must be separated by commas!")
    }
    return names
}

fun validateNamesSize(names: List<String>) {
    for (name in names) {
        if (name.length > 5) throw IllegalArgumentException("Names must not be longer than 5 characters!")
    }
}

fun getRounds(): Int {
    var input: String

    while (true) {
        println("How many rounds will be played?")
        input = Console.readLine() ?: continue
        if (input != "") break
    }

    val rounds = input.toIntOrNull() ?: throw IllegalArgumentException("Rounds must be a natural number!")
    if (rounds <= 0) throw IllegalArgumentException("At least one round is required")

    return rounds
}