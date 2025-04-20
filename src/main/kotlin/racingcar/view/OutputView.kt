package racingcar.view

import racingcar.model.Car
import racingcar.model.CarPosition
import racingcar.model.Race

object OutputView {

    fun showAllRoundResult(race: Race) {
        println()
        println("Race Results")
        for (result in race.results) {
            printEachRoundResult(result)
            println()
        }
    }

    private fun printEachRoundResult(result: List<CarPosition>) {
        result.forEach {
            println("${it.car.name} : ${"-".repeat(it.position)}")
        }
    }

    fun announceWinner(winners: List<Car>) {
        print("Winners : ")
        print(winners.joinToString { winner -> winner.name })
    }
}