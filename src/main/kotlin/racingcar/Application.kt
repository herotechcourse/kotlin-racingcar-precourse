package racingcar

fun main() {
    val carNames = InputHandler.readCarNames()
    val rounds = InputHandler.readRoundCount()

    val cars = carNames.map { Car(it) }
    RaceSimulator.runRace(cars, rounds)

    WinnerAnnouncer.announceWinners(cars)
}
