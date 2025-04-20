package racingcar

fun playRound(
    cars: List<Car>,
    shouldMove: () -> Boolean
): List<Car> = cars.map { it.move(shouldMove) }
