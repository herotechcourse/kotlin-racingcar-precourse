package racingcar.model

fun findTheWinners(carNames: List<String>, progressList: List<List<Int>>): List<String> {
    val finalRacingProgressList = progressList[progressList.size - 1]

    val maxIntProgression = finalRacingProgressList.max()
    val maxIntIndex: List<Int> = finalRacingProgressList.withIndex()
        .filter { it.value == maxIntProgression }
        .map { it.index }

    val winnersList = maxIntIndex.map { carNames[it] }

    return winnersList
}