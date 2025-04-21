package racingcar.io
import racingcar.domain.Car

class OutputProcess {
    fun printCarNameInputMessage() =
        println("Enter the names of the cars (comma-separated):")

    fun printRoundNumberInputMessage() =
        println("How many rounds will be played?")

    fun printRaceResultsMessage() =
        println("Race Results")

    fun printRoundResult(cars: List<Car>) {
        cars.forEach { car ->
            println("${car.name} : ${"-".repeat(car.getPosition())}")
        }
        println()
    }



}