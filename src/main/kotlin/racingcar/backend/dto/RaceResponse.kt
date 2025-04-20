package racingcar.backend.dto

data class RaceResponse (
    val roundNum: Int,
    val raceResultList: List<RaceResult>,
    val winnerList: List<String>,
) {
    data class RaceResult(
        val carName: String,
        val positions: List<String>
    )
}