package racingcar.domain

data class RaceResults(
    val roundResults: List<RoundResult>,
    val winners: List<Car>
) {
}
