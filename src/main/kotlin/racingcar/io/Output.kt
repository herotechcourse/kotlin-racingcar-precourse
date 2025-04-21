package racingcar.io

import kotlin.collections.iterator

/**
 * @packageName    : racingcar
 * @fileName       : OutPut
 * @author         : yong
 * @date           : 4/18/25
 */
class Output(val raceResultsMap: MutableMap<String, MutableList<String>>, val winners: String) {
    init {
        println("Race Results")
        displayRaceResults()
        displayWinners()
    }

    fun displayRaceResults() {
        val rounds = raceResultsMap.values.first().size
        for (i in 0 until rounds) {
            for ((car, roundResult) in raceResultsMap) {
                println("$car : ${roundResult[i]}")
            }
            println()
        }
    }

    fun displayWinners() {
        println("Winners : ${winners}")
    }
}