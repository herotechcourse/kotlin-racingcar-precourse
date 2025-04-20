package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("Enter the names of the cars(comma-separated):")
    val input = Console.readLine()
    val splitNames = input.split(",")
    val names = validateCarNames(splitNames)

    println("How many rounds will be played?")
    val rounds = Console.readLine()
    val numberOfRounds: Int = validateRounds(rounds)

    val cars = names.map { Car(it) }
    val race = Race(cars, numberOfRounds)
    race.startRace()
}

//Function to remove Whitespaces
fun String.removeWhitespaces() = replace(" ", "")

fun calculateWinners(cars: List<Car>) {
    print("Winners : ")
    val maxDisplacement = cars.maxOf { it.displacement }
    val winners = mutableListOf<String>()
    for (car in cars) {
        if (car.displacement == maxDisplacement) {
            winners.add(car.carName)
        }
    }
    println(winners.joinToString(", "))
}

fun validateCarNames(splitNames: List<String>):ArrayList<String> {
    val names = ArrayList<String>()

    for (name in splitNames) {
        val carName = name.removeWhitespaces()
        if (carName.isEmpty()) throw IllegalArgumentException("Car names cannot be empty.")
        if (carName.length > 5) throw IllegalArgumentException("Car names must be 5 characters or less.")
        if (names.contains(carName)) throw IllegalArgumentException("Duplicated car names are not allowed.")
        names.add(carName)
    }
    return names
}

fun validateRounds(numberOfRounds: String): Int {
    val rounds = numberOfRounds.toIntOrNull() ?: throw IllegalArgumentException("The number of rounds must be an integer.")
    if (rounds < 1) throw IllegalArgumentException("The number of rounds must be 1 or over.")
    return rounds
}

class Race (private val cars: List<Car>, private val numberOfRounds: Int){
    fun startRace() {
        println("Race Results")
        for (round in 1..numberOfRounds) {
            for (car in cars) {
                car.moveCar()
            }
            println()
        }
        calculateWinners(cars)
    }

    // For testing winners
    fun getWinners() :List<String> {
        val maxDisplacement = cars.maxOf { it.displacement }
        return cars.filter { it.displacement == maxDisplacement }.map { it.carName }
    }
}

