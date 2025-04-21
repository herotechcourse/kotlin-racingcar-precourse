package racingcar

class RaceController {
    private val raceDisplay = RaceDisplay()

    fun startRace(carNames: List<String>, rounds: Int) {
        val cars = carNames.map { Car(it) }
        val race = Race(cars, rounds, raceDisplay)
        race.start()
    }
}