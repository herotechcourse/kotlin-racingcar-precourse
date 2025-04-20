package racingcar

import camp.nextstep.edu.missionutils.Randoms

fun executeCarRace(listOfCarNames: List<String>, numberOfRounds: Int): Map<String, Int> {
    val carPositions = mutableMapOf<String, Int>()
    listOfCarNames.forEach { carName ->
        carPositions[carName] = 0
    }
    repeat(numberOfRounds) {
        executeSingleRound(listOfCarNames, carPositions)
        println()
    }
    return carPositions
}

fun executeSingleRound(listOfCarNames: List<String>, carPositions: MutableMap<String, Int>) {
    listOfCarNames.forEach { carName ->
        val randomNumber = Randoms.pickNumberInRange(0, 9)
        if (randomNumber >= 4) {
            carPositions[carName] = carPositions[carName]!! + 1
        }
        //Todo print each car's progress
    }
}