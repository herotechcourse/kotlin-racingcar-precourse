package racingcar

fun main() {

    println("Enter the names of the cars (comma-separated):")
    val carNames = splitCarNames(readOneLine())
    validateCarNames(carNames)

    val cars = makeCarList(carNames)

    println("How many rounds will be played?")
    val roundNum = parseRoundInput(readOneLine())
    validateRoundNum(roundNum)

    runRace(cars, roundNum)
    printWinners(cars)
}