package racingcar.domain.race

class RaceHistory {

    private val history: MutableList<Cars> = mutableListOf()

    fun recordRound(cars: Cars) {
        history.add(cars)
    }

    fun getRaceResult(): RaceResult {
        return RaceResult(history.last())
    }

    fun getAllRound(): List<Cars> = history.toList()
}
