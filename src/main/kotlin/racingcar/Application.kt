package racingcar

fun main() {
    try {
        val carNames = InputView.readCarNames()
        val tryCount = InputView.readTryCount()

        val cars = carNames.map { name -> Car(name) }
        val game = RacingGame(cars, tryCount)

        game.runRace()
    } catch (e: IllegalArgumentException) {
        println("[ERROR] ${e.message}")
    }
}
