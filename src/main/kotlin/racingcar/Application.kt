package racingcar

import racingcar.domain.Car
import racingcar.ui.InputView

fun main() {
    Application().run()
}

class Application {
    fun run() {
        try {
            val inputView = InputView()

            val carNames = inputView.readCarNames()
            println("Entered:  $carNames")

            val roundCount = inputView.readRounds()
            println("Entered: " + roundCount)

            val carsList = carNames.split(",").map { Car(it) }
            println("Entered: " + carsList)

            val roundsNumber = roundCount.toInt()
            println("Entered: " + roundsNumber)

            println("Input val success!")
        }
        catch (e: Exception) {
            println("Error : ${e.message}")
            e.printStackTrace()
        }
    }
}