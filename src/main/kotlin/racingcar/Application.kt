package racingcar

fun main() {
    // read input from the user and validate
    val carNames = InputView.readCarNames()
    val validatedCarNames = InputValidator.validateCarNames(carNames)

    val numberOfRounds = InputView.readNumberOfRounds()
    val validatedNumberOfRounds = InputValidator.validateNumberOfRounds(numberOfRounds)

    // create a race instance and start the race
    val race = Race.createRaceSession(validatedCarNames, validatedNumberOfRounds)
    race.startRace()
}
