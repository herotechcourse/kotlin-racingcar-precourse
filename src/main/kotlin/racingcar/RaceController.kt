package racingcar

class RaceController {
    private val raceInput = RoundsInput()
    private val raceDisplay = RaceDisplay()

    fun startRace(carNames: List<String>) {
        val cars = carNames.map { Car(it) }
        val rounds = raceInput.inputRounds()
        val race = Race(cars, rounds, raceDisplay)
        race.start()
    }
}