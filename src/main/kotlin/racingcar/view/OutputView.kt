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
        for (carPosition in result) {
            print("${carPosition.car.name} : ")
            printPosition(carPosition.position)
            println()
        }
    }

    private fun printPosition(position: Int) {
        for (i in 0..<position) {
            print("-")
        }
    }

    fun announceWinner(winners: List<Car>) {
        print("Winners : ")
        print(winners.joinToString())
    }
}