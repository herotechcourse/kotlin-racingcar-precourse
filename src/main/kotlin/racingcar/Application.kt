package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("Enter the names of the cars (comma-separated):")
    val carNames = getCarNames(Console.readLine())
    println("How many rounds will be played?")
    val numberOfRounds = getNumberOfRounds(Console.readLine())
    val race = Race(carNames, numberOfRounds)
    race.beginRace()
}
