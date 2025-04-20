package racingcar

fun findWinners(cars: List<Car>): List<String> =
    cars.filter { it.position == cars.maxOf { car -> car.position } }
        .map { it.name }
