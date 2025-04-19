package racingcar.domain

class Race(private val cars: Cars, private val round: Int) {
    fun start(): RaceResults {
        val roundResults = ArrayList<RoundResult>()
        for (i: Int in 1..round) {
            cars.move()
            roundResults.add(RoundResult(cars.getCarStatuses()))
        }
        return RaceResults(roundResults, cars.winners())
    }
}
