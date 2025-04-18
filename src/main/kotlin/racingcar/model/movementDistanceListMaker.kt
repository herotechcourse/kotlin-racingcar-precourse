package racingcar.model

fun makeRacingDistanceList(carNamesList: List<String>): MutableList<Int> {
    return MutableList(carNamesList.size) { 0 }
}