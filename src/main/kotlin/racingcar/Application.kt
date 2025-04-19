package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

data class Car(val name: String, var position: Int = 0)

fun validateCarsInput(cars: String): List<String> {
	val carsSplit = cars.split(",")
	val carsTrim = carsSplit.map { it.trim() }
	if (carsTrim.isEmpty()) {
		throw IllegalArgumentException("You must enter at least one car name.")
	}
	if (carsTrim.any { it.isEmpty() }) {
		throw IllegalArgumentException("Car names can not be blank.")
	}
	if (carsTrim.size < 2) {
		throw IllegalArgumentException("A race requires at least 2 cars.")
	}
	if (carsTrim.any { it.length > 5 }) {
		throw IllegalArgumentException("Car name must be max 5 characters long.")
	}
	if (carsTrim.distinct().size != carsTrim.size) {
		throw IllegalArgumentException("Car name must be unique.")
	}

	return carsTrim
}

fun validateRoundsInput(rounds: String): Int {
	if (rounds.isBlank()) {
		throw IllegalArgumentException("You must enter the number of rounds to race.")
	}
	val roundsToInt = rounds.toIntOrNull()
	if (roundsToInt == null) {
		throw IllegalArgumentException("The number of rounds must be an integer.")
	}
	if (roundsToInt <= 0) {
		throw IllegalArgumentException("The number of rounds must be at least 1 and positive.")
	}

	return roundsToInt
}

fun moveCars(cars: List<Car>) {
	for (car in cars) {
		val random = Randoms.pickNumberInRange(0, 9)
		if (random >= 4) {
			car.position += 1
		}
	}
}

fun printPositions(cars: List<Car>) {
	for (car in cars) {
		println("${car.name} : ${"-".repeat(car.position)}")
	}
}

class Application {
	companion object {
		@JvmStatic
		fun main(args: Array<String>) {
			println("Enter the names of the cars (comma-separated):")
			val carsInput = Console.readLine()
			val cars = validateCarsInput(carsInput)

			println("How many rounds will be played?")
			val roundsInput = Console.readLine()
			val rounds = validateRoundsInput(roundsInput)

			val carsList = cars.map { Car(it) }

			println()
			println("Race Results")

			for (round in 1..rounds) {
				moveCars(carsList)
				printPositions(carsList)
				println()
			}

			val maxPos = carsList.maxOf { it.position }
			val winningCar = carsList.filter { it.position == maxPos }
			val winner = winningCar.map { it.name }

			println("Winners: ${winner.joinToString(", ")}")
		}
	}
}
