package racingcar

class Output(private val round: Round) {

    fun printCarRaceResults(carNames: MutableMap<String, Int>, roundCount: Int) {
        repeat(roundCount) {
            printCarRaceResult(carNames)
        }
    }

    private fun printCarRaceResult(carNames: MutableMap<String, Int>) {
        carNames.forEach { (carName, movementCount) ->
            round.moveCarForward(carNames, carName)
            println("$carName : ${getCarMovementCharacters(carNames, carName, movementCount)}")
        }
        println()
    }

    private fun getCarMovementCharacters(
        carNames: MutableMap<String, Int>,
        carName: String,
        movementCount: Int,
    ) = MOVEMENT_CHARACTER.repeat(carNames.getOrDefault(carName, movementCount))

    companion object {
        private const val MOVEMENT_CHARACTER = "-"
    }
}
