package racingcar.service

import racingcar.domain.Race

class Game (
    private val race: Race,
    private val numberOfRounds: Int
){

    fun start(): Game {
        repeat(numberOfRounds) {
            race.runRound()
            printProgress()
        }
        return this
    }

    fun printProgress() {
        race.getCars().forEach{
            println("${it.getName()} : ${"-".repeat(it.getPosition())}")
        }
        println()
    }

    fun printWinners() {
        val winners = race.getWinners().map { it.getName() }
        println("Winners : ${winners.joinToString (", ")}")
    }
}
