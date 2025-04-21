package racingcar.domain

class Race(private val cars: Cars, private val round: Int) {
    fun start(): RaceResults {
        val roundResults = List(round) {
            cars.move()
            RoundResult(cars.getCarStatuses())
        }
        return RaceResults(roundResults, cars.winners())
    }
}
