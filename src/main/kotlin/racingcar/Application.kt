package racingcar

fun main() {
    val carNames = getCarNames()
    val cars = makeCarList(carNames)
    val roundNum = getNumberOfRounds()

    runRace(cars, roundNum)
    printWinners(cars)
}