package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class Car(val name: String, private val canMove: () -> Boolean) {
    var position: Int = 0
        private set
    fun moveForward() {
        if (canMove()) {
            position++
        }
    }

    fun printStatus() {
        println("$name : ${"-".repeat(position)}")
    }
}

class CarRacing(private val canMove: () -> Boolean) {
    private var cars: List<Car> = listOf()
    private var roundCount: Int = 0

    fun setCars(input: String) {
        val names = input.split(",").map { it.trim() }
        cars = names.map { name -> Car(name, canMove)}
    }

    fun setRoundCount(input: Int) {
        roundCount = input
    }

    fun race() {
        println()
        println("Race Results")
        repeat(roundCount) {
            for (car in cars) {
                car.moveForward()
                car.printStatus()
            }
            println()
        }
        getWinners()
    }

    private fun isValidNameLength(names: List<String>): Boolean {
        return !names.any { it.length > 5 }
    }

    private fun getWinners() {
        val max = cars.maxOfOrNull { it.position } ?: 0
        val winners = cars.filter { it.position == max }
        printResult(winners)
    }

    private fun printResult(winners: List<Car>) {
        val names = winners.joinToString(", ") { it.name }
        println("Winners : $names")
    }
}

fun main() {
    val canMove: () -> Boolean = { Randoms.pickNumberInRange(0, 9) >= 4 }
    val carRacing = CarRacing(canMove)

    println("Enter the names of the cars (comma-separated):")
    val rawInput = Console.readLine()
    validateCarNames(rawInput)
    val carInput = rawInput!!.trim()
    carRacing.setCars(carInput)

    println("How many rounds will be played?")
    val rawRoundInput = Console.readLine()
    val roundInput = validateRoundInput(rawRoundInput)
    carRacing.setRoundCount(roundInput)

    carRacing.race()
}

fun validateCarNames(input: String?) {
    if (input.isNullOrBlank()) {
        throw IllegalArgumentException("Car name cannot be empty.")
    }

    val names = input.split(",").map { it.trim() }

    if (names.any { it.isEmpty() }) {
        throw IllegalArgumentException("Car name cannot be blank.")
    }

    if (names.any { it.length >5 }) {
        throw IllegalArgumentException("Car names must be 5 characters or fewer.")
    }
}

fun validateRoundInput(input: String?): Int {
    if (input.isNullOrBlank()) {
        throw IllegalArgumentException("Number of rounds cannot be empty.")
    }

    return input.toIntOrNull()
        ?: throw IllegalArgumentException("Please enter a valid number.")
}