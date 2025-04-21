package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

class Race(
    val cars: List<Car>,
    val totalRound: Int,
    val results: MutableList<List<CarPosition>> = mutableListOf(),
) {
    companion object {
        private const val RANDOM_MIN = 0
        private const val RANDOM_MAX = 9
    }

    fun runRace(randomNumberGenerator: () -> Int = { Randoms.pickNumberInRange(RANDOM_MIN, RANDOM_MAX) }) {
        repeat(totalRound) {
            runEachRound(randomNumberGenerator)
            saveRoundResult()
        }
    }

    private fun runEachRound(randomNumberGenerator: () -> Int) {
        cars.forEach { it.moveRandomly(randomNumberGenerator()) }
    }

    private fun saveRoundResult() {
        val roundSnapshot = cars.map { CarPosition(it, it.position) }
        results.add(roundSnapshot)
    }

    fun getWinner(): List<Car> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }
    }
}