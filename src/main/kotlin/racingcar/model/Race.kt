package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

data class Race(val cars: Cars, val rounds: Int) {

    init {
        require(rounds >= 1) { "Round must be greater than or equal to 1" }
    }

    fun play(): RaceResult {
        val raceLog: MutableList<LapReport> = mutableListOf()

        repeat(rounds) {
            cars.moveAll { Randoms.pickNumberInRange(0, 9) }
            raceLog += cars.toLapReport()
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
