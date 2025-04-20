package racingcar.view

import racingcar.model.Car
import racingcar.model.CarPosition
import racingcar.model.Race

object OutputView {

    fun showAllRoundResult(race: Race) {
        println("\nRace Results")
        race.results.forEach { printEachRoundResult(it) }
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