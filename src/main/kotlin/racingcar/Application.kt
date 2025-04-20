package racingcar

fun main() {
        val rawCarNames = InputHandler.readCarNames()
        val carNames = InputHandler.validateCarNames(rawCarNames)
        val rawRounds = InputHandler.readRounds()
        val rounds = InputHandler.validateRounds(rawRounds)

        val cars: List<Car> = carNames.map() { Car(it) } // this is a lambda (anonymous function)
        val raceGame = RaceGame(cars, rounds)
        raceGame.runRace()
}
