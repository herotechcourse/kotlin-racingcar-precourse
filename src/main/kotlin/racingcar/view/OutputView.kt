package racingcar.view

import racingcar.model.Car
import racingcar.model.Rules

object OutputView {
    fun printRaceIntro() {
        println("\nRace Results")
    }

    fun printRoundResult(cars: List<Car>){
        cars.forEach{
            println("${it.name()} : ${Rules.OUTPUT_SYMBOL.repeat(it.position())}")
        }
        println()
    }

    fun printWinners(winners: List<Car>) {
        val winnerNames=winners.joinToString(", ") {it.name()}
        println("Winners : $winnerNames")
    }
}