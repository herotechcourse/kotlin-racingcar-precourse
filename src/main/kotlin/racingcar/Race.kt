package racingcar

fun playRound(
    cars: List<Car>,
    shouldMove: () -> Boolean
): List<Car> = cars.map { it.move(shouldMove) }

fun runRace(
    cars: List<Car>,
    rounds: Int,
    shouldMove: () -> Boolean
): List<List<Car>> =
    generateSequence(cars) { current ->
        playRound(current, shouldMove)
    }
        .drop(1)
        .take(rounds)
        .toList()
