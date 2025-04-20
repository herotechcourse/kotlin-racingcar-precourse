package racingcar.model

class Race(
    var cars: List<Car>,
    var totalRound: Int,
    var results: MutableList<List<CarPosition>> = mutableListOf(),
) {
    fun runRace() {
        for (i in 1..totalRound) {
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