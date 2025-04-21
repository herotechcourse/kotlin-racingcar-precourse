package racingcar.view

import racingcar.model.Cars

class OutputView {
    fun printRacingStart() {
        println()
        println(RACING_START_PROMPT)
    }

    fun printStageResult(cars: Cars) {
        for (car in cars.getCars()) {
            println(car.carName + CLONE_STRING_FORMAT + getMoveDistance(car.position))
        }
        println()
    }

    fun printWinners(winnerNames: List<String>) {
        println(WINNER_PROMPT + "${winnerNames.joinToString(", ")}")
    }

    private fun getMoveDistance(position: Int): String {
        var moveDistance = ""
        for (i in 0 until position) {
            moveDistance += MOVE_EXPRESSION
        }
        return moveDistance
    }

    companion object {
        private const val CLONE_STRING_FORMAT = " : "
        private const val MOVE_EXPRESSION = "-"
        private const val WINNER_PROMPT = "Winners : "
        private const val RACING_START_PROMPT = "Race Results"
    }
}
