package racingcar.view

import racingcar.model.RacingState

object ViewRenderer {
    fun render(state: RacingState) {
        state.cars.forEach {
            println("${it.name} : ${"-".repeat(it.position)}")
        }
        println()
    }

    fun renderWinners(state: RacingState) {
        val max = state.cars.maxOf { it.position }
        val winners = state.cars.filter { it.position == max }.map { it.name }
        println("Winners : ${winners.joinToString(", ")}")
    }
}
