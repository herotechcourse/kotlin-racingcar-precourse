package racingcar.backend.dto

data class RaceRequest(
    val carList: List<CarDto>,
    val roundCount: Int,
)