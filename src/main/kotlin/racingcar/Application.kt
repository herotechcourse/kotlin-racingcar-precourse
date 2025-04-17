package racingcar

fun main() {
    val theRace = CarRace.initializeRace()

    theRace.startRace()
    val winners = theRace.selectWinners()
    println("Winners : ${winners.joinToString(", ")}")
}