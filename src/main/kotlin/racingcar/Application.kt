package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

data class Car(val name: String, var position: Int = 0)

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
			val cars_input = Console.readLine()
			val cars_split = cars_input.split(",")
			val cars_trim = cars_split.map{it.trim()}
			if (cars_trim.isEmpty()) {
				throw IllegalArgumentException("You must enter at least one car name.")
			}
			if (cars_trim.any{it.isEmpty()}) {
				throw IllegalArgumentException("Car names can not be blank.")
			}
			if (cars_trim.size < 2) {
				throw IllegalArgumentException("A race requires at least 2 cars.")
			}
			if (cars_trim.any{it.length > 5}) {
				throw IllegalArgumentException("Car name must be max 5 characters long.")
			}
			if (cars_trim.distinct().size != cars_trim.size) {
				throw IllegalArgumentException("Car name must be unique.")
			}
			println("Car names: $cars_trim")

			println("How many rounds will be played?")
			val rounds_input = Console.readLine()
			if (rounds_input.isBlank()) {
				throw IllegalArgumentException("You must enter the number of rounds to race.")
			}
			val rounds_toInt = rounds_input.toIntOrNull()
			if (rounds_toInt == null) {
				throw IllegalArgumentException("The number of rounds must be an integer.")
			}
			if (rounds_toInt <= 0) {
				throw IllegalArgumentException("The number of rounds must be at least 1 and positive.")
			}
			println("Number of rounds: $rounds_input")

			val cars_list = cars_trim.map{Car(it)}

			println()
			println("Race Results")

			for (round in 1..rounds_toInt) {
				moveCars(cars_list)
				printPositions(cars_list)
				println()
			}

			val max_pos = cars_list.maxOf{it.position}
			val winning_car = cars_list.filter{it.position == max_pos}
			val winner = winning_car.map{it.name}

			println("Winners: ${winner.joinToString(", ")}")
		}
	}
}
