package racingcar.model

data class RacingState(
    val cars: List<Car> = emptyList(),
    val currentRound: Int = 0,
    val totalRounds: Int = 0,
    val raceFinished: Boolean = false
)
