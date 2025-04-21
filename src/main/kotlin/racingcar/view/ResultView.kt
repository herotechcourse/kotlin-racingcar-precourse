package racingcar.view

object ResultView {
    fun printResultHeader() {
        println("\nRace Results")
    }

    fun printRound(cars: List<CarView>) {
        cars.forEach { car ->
            println(formatCarResult(car))
        }
        println()
    }

    fun printWinners(winners: List<String>) {
        println("Winners : ${winners.joinToString(", ")}")
    }

    fun formatCarResult(car: CarView): String {
        return "${car.name} : ${"-".repeat(car.position)}"
    }
}
