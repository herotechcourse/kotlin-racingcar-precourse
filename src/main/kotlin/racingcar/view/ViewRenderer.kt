package racingcar.view

import racingcar.model.RacingState

object ViewRenderer {
    fun render(state: RacingState) {
        println("Round ${state.currentRound}")
        state.cars.forEach {
            println("${it.name} : ${it.progress()}")
        }
        println()
    }

    fun renderWinners(state: RacingState) {
        val max = state.cars.maxOfOrNull { it.position } ?: return
        val winners = state.cars.filter { it.position == max }.joinToString(", ") { it.name }
        println("Winners : $winners")
    }
}
