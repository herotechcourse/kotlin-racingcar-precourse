package racingcar.model

class Race(
    val cars: List<Car>,
    val totalRound: Int,
    val results: MutableList<List<CarPosition>> = mutableListOf(),
) {
    fun runRace() {
        repeat(totalRound) {
            runEachRound()
            saveRoundResult()
        }
    }

    private fun runEachRound() {
        cars.forEach { it.moveRandomly() }
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