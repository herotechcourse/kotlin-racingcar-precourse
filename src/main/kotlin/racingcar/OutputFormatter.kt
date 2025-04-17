package racingcar

object OutputFormatter {

    fun formatResults(cars: List<Car>) {
        println()
        cars.forEach { car ->
            val carName = car.carName
            val progress = "-".repeat(car.getPosition())
            println("$carName : $progress")
        }
    }

    fun formatFinalWinners(cars: List<Car>) {
        val carWinnersNames = cars.joinToString(", ") { it.carName }
        println()
        println("Winners : $carWinnersNames")
    }
}
