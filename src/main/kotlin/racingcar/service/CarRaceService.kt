package racingcar.service

import camp.nextstep.edu.missionutils.Randoms
import racingcar.models.Race


class CarRaceService {
    fun runCarRace(carNames: List<String>, roundCount: Int) {
        val race = Race(carNames)

        println("\nRace Results")
        repeat(roundCount) {
            race.runRound()
            race.printStatus()
        }

        val winners = race.findWinners()
        println("Winners : ${winners.joinToString(", ")}")
    }
}