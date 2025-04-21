package racingcar

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

class Car(val name: String) {
    var movedRounds: Int = 0
        private set

    fun runRound() {
        if (Randoms.pickNumberInRange(0, 9) >= MOVE_THRESHOLD) {
            movedRounds++
        }
    }

    fun printStatus() {
        println("$name : ${"-".repeat(movedRounds)}")
    }

    companion object {
        private const val MOVE_THRESHOLD = 4
    }
}

class CarRacing {
    private val cars = mutableListOf<Car>()
    private var totalRound: Int = 0

    fun run() {
        init()
        race()
        printResult()
    }

    private fun init() {
        println("Enter the names of the cars (comma-separated):")
        getCarInput()

        println("How many rounds will be played?")
        getRoundInput()

        println()
    }

    private fun getCarInput() {
        val input = Console.readLine()?.trim()
            ?: throw IllegalArgumentException("Invalid Input: names are NULL.")

        if (input.isEmpty())
            throw IllegalArgumentException("Invalid Input: names are empty")

        val names = input.split(",").map { it.trim() }

        if (names.any { !it.matches(Regex("^[A-Za-z1-9 ]+$")) })
            throw IllegalArgumentException("Invalid input: only alphabets, numbers, or spaces are allowed..")

        if (names.any { it.length > 5 })
            throw IllegalArgumentException("Invalid input: name cannot exceed 5 characters")

        for (name in names) {
            cars.add(Car(name))
        }
    }

    private fun getRoundInput() {
        val input = Console.readLine()?.trim()
            ?: throw IllegalArgumentException("Invalid Input: round is NULL.")

        try {
            val round = input.toInt()
            if (round < 1) throw IllegalArgumentException("Invalid Input: only positive numbers are allowed.")
            totalRound = round
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("Invalid Input: only Integer values are allowed")
        }
    }

    private fun race() {
        println("Race Results")

        for (round in 1..totalRound) {
            for (car in cars) {
                car.runRound()
                car.printStatus()
            }
            println()
        }
    }

    private fun printResult() {
        val maxMoved = cars.maxOfOrNull { it.movedRounds } ?: 0
        val winners = cars.filter { it.movedRounds == maxMoved }.map { it.name }

        println("Winners : ${winners.joinToString(", ")}")
    }
}


fun main() {
    // TODO: Implement the program

    val carRacing = CarRacing()

    carRacing.run()
}