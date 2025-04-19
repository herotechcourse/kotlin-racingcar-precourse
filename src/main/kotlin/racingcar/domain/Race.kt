package racingcar.domain

/**
 * Represents a complete race simulation containing multiple cars competing over several rounds.
 * Tracks the history of car position throughout the race and determines winners.
 */
class Race(private val cars: List<Car>, private val rounds: Int) {
    private val _raceHistory = List(rounds) { MutableList<Pair<String, Int>>(cars.size) { "" to 0 } }
    // Public read-only access to the race history
    val raceHistory: List<List<Pair<String, Int>>> get() = _raceHistory

    /**
     * Simulate the entire race by running all rounds sequentially.
     */
    fun simulate() {
        for (round in 0 until rounds) {
            simulateRound(round)
        }
    }

    /**
     * Simulate a single round of the race.
     * Updates each car's position and records the results in race history.
     */
    private fun simulateRound(round: Int) {
        cars.forEachIndexed { index, car ->
            car.progress()
            _raceHistory[round][index] = car.name to car.progression
        }
    }

    /**
     * Determines the winner(s) of the race based on final positions.
     * If multiple cars have the same maximum position, all are considered winner.
     */
    fun getWinners(): List<String> {
        val finalRound: List<Pair<String, Int>> = _raceHistory.last()
        val maxProgression = finalRound.maxOfOrNull { it.second } ?: return emptyList()
        return finalRound.asSequence().filter { it.second == maxProgression }.map { it.first }.toList()
    }
}