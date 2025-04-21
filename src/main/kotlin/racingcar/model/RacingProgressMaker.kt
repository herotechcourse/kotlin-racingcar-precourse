package racingcar.model

fun makeRacingProgressList(carNames: List<String>, racingRounds: Int): MutableList<List<Int>> {
    val racingProgress = MutableList(carNames.size) { 0 }
    val allRoundProgress = mutableListOf<List<Int>>()

    repeat(racingRounds) {
        racingProgress.indices.forEach { index ->
            if (decideProgress()) {
                racingProgress[index] += 1
            }
        }

        allRoundProgress.add(racingProgress.toList())
    }

    return allRoundProgress
}