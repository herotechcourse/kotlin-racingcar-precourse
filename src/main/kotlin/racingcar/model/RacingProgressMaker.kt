package racingcar.model

fun makeRacingProgressList(carNamesList: List<String>, theNumberOfRounds: Int): MutableList<List<Int>> {
    val racingProgress = MutableList(carNamesList.size) { 0 }
    val allRoundProgress = mutableListOf<List<Int>>()

    repeat(theNumberOfRounds) {
        racingProgress.indices.forEach { index ->
            if (decideProgress()) {
                racingProgress[index] += 1
            }
        }

        allRoundProgress.add(racingProgress.toList())
    }

    return allRoundProgress
}