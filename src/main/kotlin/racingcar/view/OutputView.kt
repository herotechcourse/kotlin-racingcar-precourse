package racingcar.view

import racingcar.model.Car

object OutputView {
    fun printRaceIntro() {
        println("\nRace Results")
    }

    fun printRoundResult(cars: List<Car>){
        cars.forEach{
            println("${it.name()} : ${"-".repeat(it.position())}")
        }
        println()
    }

    fun printWinners(winners: List<Car>) {
        val winnerNames=winners.joinToString(", ") {it.name()}
        println("Winners : $winnerNames")
    }
}