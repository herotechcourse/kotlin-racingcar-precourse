package racingcar.domain.race

class Race(val round: Round, val cars: Cars) {

    private val raceHistory = RaceHistory()

    fun play(): RaceResult {
        var currentCars = cars

        repeat(round.value) {
            currentCars = currentCars.moveAll()
            raceHistory.recordRound(currentCars)
        }
        return raceHistory.getRaceResult()
    }

    fun getAllRounds(): List<Cars> {
        return raceHistory.getAllRound()
    }
}
