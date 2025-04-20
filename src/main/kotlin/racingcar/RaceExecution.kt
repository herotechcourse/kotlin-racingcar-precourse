package racingcar

fun executeCarRace(listOfCarNames: List<String>, numberOfRounds: Int): Map<String, Int> {
    val carPositions = mutableMapOf<String, Int>()
    listOfCarNames.forEach { carName ->
        carPositions[carName] = 0
    }
    repeat(numberOfRounds) {
        //Todo: execute single-round race
    }
    return carPositions
}