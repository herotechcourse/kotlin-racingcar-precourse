package racingcar

class Output(private val round: Round) {

    fun printCarRaceResults(cars: Set<Car>, roundCount: Int) {
        repeat(roundCount) {
            printCarRaceResult(cars)
        }
    }

    fun printWinners(cars: Set<Car>) {
        val winners = round.getWinners(cars)
        println("Winners : ${winners.formatWinners()}")
    }

    private fun printCarRaceResult(cars: Set<Car>) {
        cars.forEach { car ->
            car.moveForward(START_NUMBER, END_NUMBER)
            println("${car.name} : ${convertIntToRepeatedString(car.movementCount)}")
        }
        println()
    }

    private fun convertIntToRepeatedString(intValue: Int) = MOVEMENT_CHARACTER.repeat(intValue)

    private fun List<Car>.formatWinners() = joinToString(SEPARATOR) { it.name }

    companion object {
        private const val START_NUMBER = 0
        private const val END_NUMBER = 9

        private const val MOVEMENT_CHARACTER = "-"
        private const val SEPARATOR = ", "
    }
}
