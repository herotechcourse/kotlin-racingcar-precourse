package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class RaceCars {
    private lateinit var cars: List<Car>
    private var rounds: Int = 0

    fun start() {
        startRaces()
    }

    private fun startRaces() {
        getNames()
        getRounds()
    }

    private fun getNames() {
        println(
            buildString {
                append("Enter the names of the cars. Make sure to:\n- Separate them by a comma and no spaces.")
                append("\n- Use less than five characters per car name.")
            },
        )
        val carNames = Console.readLine()
        val listOfCars = carNames.split(",").map { it.trim() }

        validateCarNames(listOfCars)
        cars = listOfCars.map { Car(it) }
    }

    private fun getRounds() {
        println("Enter the number of rounds to race:")
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
            validateSpaces(name)
            validateEmpty(name)
            validateNameLength(name)
        }
    }

    private fun validateSpaces(str: String): Boolean {
        return !str.any { it.isWhitespace() }
    }

    private fun validateEmpty(name: String) {
        if (name.isEmpty()) {
            throw IllegalArgumentException("You didn't provide a car name.")
        }
    }

    private fun validateNameLength(name: String) {
        if (name.length > 5) {
            throw IllegalArgumentException("The car '$name' is longer than 5 characters.")
        }
    }

    private fun eachRound(round: Int) {
        println("Race round $round")

        cars.forEach { car ->
            getCarMovement(car)
            displayAdvancement(car)
        }
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
}