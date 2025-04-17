package racingcar.ui

import racingcar.car.Car
import camp.nextstep.edu.missionutils.Console
import racingcar.car.RandomMoveStrategy
import java.lang.IllegalArgumentException

class InputView {
    fun getCars(): List<Car> {
        println("Enter the names of the cars (comma-separated):")
        val carsString: String? = Console.readLine()

        if (carsString.isNullOrBlank()) {
            throw IllegalArgumentException("Invalid car names")
        }

        val names = carsString.split(",").map { it.trim() }

        if (names.any { it.isEmpty() }) {
            throw IllegalArgumentException("Car names cannot be blank")
        }

        return names.map { Car(it, RandomMoveStrategy()) }
    }
    fun getRounds(): Int {
        println("How many rounds will be played?")
        val rounds = Console.readLine()?.toIntOrNull() ?: throw IllegalArgumentException("Invalid rounds")
        if (rounds <= 0) {
            throw IllegalArgumentException("Number of rounds must be a positive integer")
        }
        return rounds
    }
}