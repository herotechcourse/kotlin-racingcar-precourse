package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

data class Race(val cars: Cars, val rounds: Rounds) {

    fun play(): RaceResult {
        val raceLog = buildList {
            rounds.repeat {
                cars.moveAll { Randoms.pickNumberInRange(0, 9) }
                add(cars.toLapReport())
            }
        }

        return RaceResult(raceLog, cars.findWinners());
    }

}

class Cars(private val cars: List<Car>) {

    fun moveAll(powerGenerator: () -> Int) {
        cars.forEach { it.move(powerGenerator()) }
    }

    fun toLapReport(): LapReport = LapReport.from(cars)

    fun findWinners(): List<Name> {
        val max: Position = cars.maxOf { it.position }

        return cars.filter { it.position == max }.map { it.name }
    }

}

data class Rounds(private val count: Int) {

    init {
        require(count >= MIN_COUNT) { "Round must be greater than or equal to 1" }
    }

    fun repeat(action: () -> Unit) {
        repeat(count) {
            action()
        }
    }

    companion object {
        const val MIN_COUNT = 1
    }
}
