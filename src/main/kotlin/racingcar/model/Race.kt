package racingcar.model

data class Race(val cars: Cars, val rounds: Rounds) {

    fun play(powerGenerator: PowerGenerator): RaceResult {
        val raceLog = buildList {
            rounds.repeat {
                cars.moveAll(powerGenerator)
                add(cars.toLapReport())
            }
        }

        return RaceResult(raceLog, cars.findWinners());
    }

}

class Cars(private val cars: List<Car>) {

    fun moveAll(powerGenerator: PowerGenerator) {
        cars.forEach { it.move(powerGenerator.generate()) }
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
