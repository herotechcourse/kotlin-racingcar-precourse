package racingcar.service

import racingcar.domain.Race
import racingcar.service.movement.MovementStrategy

class RaceService(
    private val strategy: MovementStrategy
) {
    fun play(race: Race, rounds: Int): Pair<List<List<String>>, Race> {
        var currentRace = race
        val history = mutableListOf<List<String>>()

        repeat(rounds) {
            currentRace = currentRace.moveAll(strategy)
            history.add(currentRace.display())
        }

        return Pair(history, currentRace)
    }
}
