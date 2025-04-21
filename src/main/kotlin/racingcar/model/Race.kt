package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

data class Race(val cars: List<Car>, val rounds: Int) {

    init {
        require(rounds >= 1) { "Round must be greater than or equal to 1" }
    }

    fun play(): RaceResult {
        val raceLog: MutableList<LapReport> = mutableListOf()

        repeat(rounds) {
            cars.forEach { it.move(Randoms.pickNumberInRange(0, 9)) }
            raceLog += LapReport.from(cars)
        }

        return RaceResult(raceLog, findWinners());
    }

    private fun findWinners(): List<Name> {
        val max: Position = cars.maxOf { it.position }

        return cars.filter { it.position == max }.map { it.name }
    }

}
