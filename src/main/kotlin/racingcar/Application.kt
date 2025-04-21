package racingcar

fun main() {
    val carNames = getValidCarNames()
    val roundCount = getValidRoundCount()

    CarRacing.runRace(carNames, roundCount)
}
