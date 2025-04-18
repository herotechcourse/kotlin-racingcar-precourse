package racingcar.domain

class Race(private val cars: List<Car>, private val rounds: Int) {
    private val _raceHistory = List(rounds) { MutableList<Pair<String, Int>>(cars.size) { "" to 0 } }

    val raceHistory: List<List<Pair<String, Int>>> get() = _raceHistory

    fun simulate() {
        for (round in 0 until rounds) {
            simulateRound(round)
        }
    }

    private fun simulateRound(round: Int) {
        cars.forEachIndexed { index, car ->
            car.progress()
            _raceHistory[round][index] = car.name to car.progression
        }
    }

    fun getWinners(): List<String> {
        val finalRound: List<Pair<String, Int>> = _raceHistory.last()
        val maxProgression = finalRound.maxOfOrNull { it.second } ?: return emptyList()
        return finalRound.asSequence().filter { it.second == maxProgression }.map { it.first }.toList()
    }
}