package racingcar

fun main() {
    val theRace: CarRace

    try {
        theRace = CarRace.initializeRace()
    } catch (e: Exception) {
        println("Error: ${e.message}")
        return
    }

    theRace.startRace()
    val winners = theRace.selectWinners()
    println("Winners: $winners")
}