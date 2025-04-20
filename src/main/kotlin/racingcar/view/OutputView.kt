package racingcar.view

import racingcar.model.Car

class OutputView {
    fun printRaceResultsMessage() {
        println(MESSAGE_RACE_RESULTS)
    }

    fun printRaceResults(cars: List<Car>) {
        cars.forEach { car ->
            print("${car.name} : ")
            printProgress(car)
            print("\n")
        }
        print("\n")
    }

    private fun printProgress(car: Car) {
        repeat(car.position) {
            print(MESSAGE_PROGRESS_BAR)
        }
    }

    fun printWinners(winners: List<Car>) {
        val winnersOutput = winners.joinToString(MESSAGE_SEPARATOR) { it.name }
        println(MESSAGE_WINNERS + winnersOutput)
    }

    companion object {
        private const val MESSAGE_RACE_RESULTS = "Race Results"
        private const val MESSAGE_PROGRESS_BAR = "-"
        private const val MESSAGE_SEPARATOR = ", "
        private const val MESSAGE_WINNERS = "Winners : "
    }
}
