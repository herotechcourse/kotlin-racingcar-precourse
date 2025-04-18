package racingcar.ui

import racingcar.car.Car
import camp.nextstep.edu.missionutils.Console
import racingcar.car.RandomMoveStrategy
import java.lang.IllegalArgumentException

class InputView {
    fun getCars(): List<Car> {
        println("Enter the names of the cars (comma-separated):")
        val carsString: String = Console.readLine()
            .validateNotNullOrBlank("Invalid input")
        val names = getCarNames(carsString)
        return names.map { Car(it, RandomMoveStrategy()) }
    }

    private fun String?.validateNotNullOrBlank(errorMessage: String):String {
        if (this.isNullOrBlank()) {
            throw IllegalArgumentException(errorMessage)
        }
        return this
    }

    private fun getCarNames(carsString: String): List<String> {
        val names = carsString.split(",").map { it.trim() }
        validateCarNameIsNotEmpty(names)
        validateCarNameIsNotDuplicate(names)
        return names
    }

    private fun validateCarNameIsNotEmpty(names: List<String>) {
        if (names.any { it.isEmpty() }) {
            throw IllegalArgumentException("Car names cannot be blank")
        }
    }

    private fun validateCarNameIsNotDuplicate(names: List<String>) {
        val duplicates = names.groupBy { it }.filter { it.value.size>1 }.keys
        if (duplicates.isNotEmpty()) {
            throw IllegalArgumentException("Duplicate car names found")
        }
    }

    fun getRounds(): Int {
        println("How many rounds will be played?")
        val rounds = Console.readLine()?.toIntOrNull()
            ?: throw IllegalArgumentException("Invalid rounds")
        validatePositive(rounds)
        return rounds
    }

    private fun validatePositive(rounds: Int) {
        if (rounds <= 0) {
            throw IllegalArgumentException("Number of rounds must be a positive integer")
        }
    }
}