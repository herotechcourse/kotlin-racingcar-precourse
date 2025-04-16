package racingcar

import camp.nextstep.edu.missionutils.Randoms
import racingcar.car.Car
import racingcar.io.InputHandler
import racingcar.validator.InputValidator

fun main() {
    val carNamesInput = InputHandler.readInput("Enter the names of the cars (comma-separated):")
    InputValidator.checkEmptyInput(carNamesInput)

    val carNames = carNamesInput.split(",").map { it.trim() }
    InputValidator.validateCarNames(carNames)

    val roundCountsInput = InputHandler.readInput("How many rounds will be played?").trim()
    InputValidator.validateRoundCount(roundCountsInput)

    val roundCount = roundCountsInput.toInt()
    val cars = carNames.map { Car(it) }

    for (i in 1..roundCount) {
        cars.forEach { car ->
            val randomNumber = Randoms.pickNumberInRange(0, 9)
            if (randomNumber >= 4) {
                car.moveForward()
            }
            val movement = "-".repeat(car.position)
            println("${car.name} : $movement")
        }
        println()

    }

    val maxPosition = cars.maxOf { it.position }
    val winners = cars.filter { it.position == maxPosition }
    println("Winners : ${winners.joinToString(", ") { it.name }}")
}
