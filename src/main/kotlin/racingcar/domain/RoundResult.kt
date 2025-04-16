package racingcar.domain

class RoundResult(cars: List<Car>) {
    val results: Map<String, Int> =
        cars.associate { it.name.name to it.position }
}
