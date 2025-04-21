package racingcar

class RacingCarGame {
    fun start() {
        val carNames = Input.readCarNames()
        val rounds = Input.readNumberOfRounds()
        val cars = carNames.map { Car(it) }

        println("\nRace Results")
        repeat(rounds) {
            cars.forEach { it.tryToMove() }
            Output.printRoundResult(cars)
        }

        Output.printWinners(cars)
    }
}