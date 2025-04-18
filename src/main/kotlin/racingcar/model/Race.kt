package racingcar.model

class Race(
    var cars: List<Car>,
    var totalRound: Int,
    var results: List<CarPosition> = emptyList(),
) {
}