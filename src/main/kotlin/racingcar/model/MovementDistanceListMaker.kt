package racingcar.model

import racingcar.model.decideMovement

fun makeRacingProgressList(carNamesList: List<String>, theNumberOfRounds: Int): MutableList<List<Int>> {
    val racingProgress = MutableList(carNamesList.size) { 0 }
    val allRoundProgress = mutableListOf<List<Int>>()

    repeat(theNumberOfRounds) {
        racingProgress.indices.forEach { index ->
            if (decideMovement()) {
                racingProgress[index] += 1
            }
        }

        allRoundProgress.add(racingProgress.toList())
    }

    return allRoundProgress
}



