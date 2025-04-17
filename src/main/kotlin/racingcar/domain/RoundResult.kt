package racingcar.domain

class RoundResult(cars: List<Car>) {
    val results: Map<CarName, Position> =
        cars.associate { it.name to it.position }
}
