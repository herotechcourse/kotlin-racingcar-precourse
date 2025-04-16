package racingcar.ui

import racingcar.car.Car
import camp.nextstep.edu.missionutils.Console
import java.lang.IllegalArgumentException

class InputView {
    fun getCars(): List<Car> {
        println("Enter the names of the cars (comma-separated):")
        val carsString: String? = Console.readLine()
        return if (carsString.isNullOrBlank()) {
            throw IllegalArgumentException("Invalid car names")
        } else {
            carsString.split(",")
                .map { it.trim() }
                .filter { it.isNotEmpty() }
                .map { Car(it) }
        }
    }
    fun getAttempts(): Int {
        println("How many rounds will be played?")
        return Console.readLine()?.toIntOrNull() ?: throw IllegalArgumentException("Invalid attempts")
    }
}