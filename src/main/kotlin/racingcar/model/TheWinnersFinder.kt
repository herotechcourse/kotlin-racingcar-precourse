package racingcar.model

fun findTheWinnersIndex(finalResultProgressInt: List<Int>): List<Int> {
    val maxIntProgression = finalResultProgressInt.max()

    val maxIntIndex: List<Int> = finalResultProgressInt.withIndex()
        .filter { it.value == maxIntProgression }
        .map { it.index }

    return maxIntIndex
}