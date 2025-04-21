package racingcar.model

data class RaceResult(val raceLog: List<LapReport>, val winners: List<Name>)

data class LapReport(val statuses: List<LapStatus>) {

    companion object {
        fun from(cars: List<Car>): LapReport = LapReport(cars.map { LapStatus(it.name, it.position) })
    }
}

data class LapStatus(val name: Name, val position: Position)
