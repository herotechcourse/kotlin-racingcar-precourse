package racingcar

import camp.nextstep.edu.missionutils.Console

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
		}
	}
}
