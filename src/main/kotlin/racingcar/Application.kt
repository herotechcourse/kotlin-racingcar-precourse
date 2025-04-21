package racingcar

fun main() {
    val carNames = getValidCarNames()
    val roundCount = getValidRoundCount()

    RacingGame.runRace(carNames, roundCount)
}
