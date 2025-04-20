package racingcar

fun main() {
        val carNames = InputHandler.getValidatedCarNames()
        val rounds = InputHandler.getValidatedRounds()

        val cars: List<Car> = carNames.map() { Car(it) }
        val raceGame = RaceGame(cars, rounds)
        raceGame.runRace()
}
