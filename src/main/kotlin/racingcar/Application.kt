package racingcar

fun main() {

    println("Enter the names of the cars (comma-separated):")
    val carNames = splitCarNames(readOneLine())
    validateCarNames(carNames)

    println("How many rounds will be played?")
    val roundNum = parseRoundInput(readOneLine())
    validateRoundNum(roundNum)

    val cars = convertToCars(carNames) // Convert string list into Car instance list
    val race = Race(cars, roundNum)

    race.runRace()
    race.printWinners()
}