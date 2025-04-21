package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class RaceCars {
    private lateinit var cars: List<Car>
    private var rounds: Int = 0

    fun start() {
        startRaces()
        race()
        displayWinners()
    }

    private fun startRaces() {
        getNames()
        getRounds()
    }

    private fun getNames() {
        println("Names of the cars (comma-separated):")
        val carNames = Console.readLine()
        val listOfCars = carNames.split(",").map { it.trim() }

        validateCarNames(listOfCars)
        cars = listOfCars.map { Car(it) }
    }

    private fun getRounds() {
        println("Number of rounds:")
        val roundsInput = Console.readLine()

        rounds = createRoundCount(roundsInput)
    }

    private fun createRoundCount(roundsStr: String): Int {
        try {
            val parsed = roundsStr.toInt()
            if (parsed <= 0) {
                throw IllegalArgumentException("Enter a positive number of rounds")
            }
            return parsed
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("This $roundsStr is an invalid number of rounds")
        }
    }

    private fun validateCarNames(separatedCarNames: List<String>) {
        if (separatedCarNames.isEmpty()) {
            throw IllegalArgumentException("Please provide the car names")
        }
        validateEachCar(separatedCarNames)
    }

    private fun validateEachCar(separatedCarNames: List<String>) {
        separatedCarNames.forEach { name ->
//            validateEmpty(name)
            validateNameLength(name)
        }
    }

/*    private fun validateEmpty(name: String) {
        if (name.isEmpty()) {
            throw IllegalArgumentException("You didn't provide a car name.")
        }
    }*/

    private fun validateNameLength(name: String) {
        if (name.length > 5) {
            throw IllegalArgumentException("The car '$name' is longer than 5 characters.")
        }
    }

    private fun eachRound(round: Int) {
        cars.forEach { car ->
            getCarMovement(car)
            displayAdvancement(car)
        }
        println()
    }

    private fun getCarMovement(car: Car) {
        val movePosition = moveCar()
        if (movePosition) {
            car.position++
        }
    }

    private fun moveCar(): Boolean {
        return Randoms.pickNumberInRange(0, 9) >= 4
    }

    private fun displayAdvancement(car: Car) {
        val advancement = "-".repeat(car.position)
        car.lastPosition = car.position

        println("${car.name}: $advancement")
    }

    private fun race() {
        println("Race Results")
        for (round in 1..rounds) {
            eachRound(round)
        }
    }

    private fun displayWinners() {
        val highestPosition = getHighestPosition()
        val winners = getWinners(highestPosition)
        val outputWinners = winners.joinToString(", ") { it.name }

        println("Winners: $outputWinners")
    }

    private fun getHighestPosition(): Int {
        return cars.maxOf { it.position }
    }

    private fun getWinners(highestPosition: Int): List<Car> {
        return cars.filter { it.position == highestPosition }
    }
}