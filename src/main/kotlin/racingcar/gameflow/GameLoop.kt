package racingcar.gameflow

import racingcar.model.Car

fun raceUpdateTrack(
    cars: List<Car>,
    generateNumber: () -> Int,
    isMovable: (Int) -> Boolean
) {
    cars.forEach { it.position++ }
    // TODO: Replace with real implementation after merge
}

// Output is currently untestable, so focus on logic testing.
fun outputRoundResult(cars: List<Car>, round: Int) {
    // TODO: Implement in Output Module later
}

fun outputFinalWinner(cars: List<Car>) {
    // TODO: Implement in Output Module later
}

fun gameLoop(cars: List<Car>,
             nRounds: Int,
             generateNumber: () -> Int,
             isMovable: (Int) -> Boolean) {
    repeat(nRounds) { eachRound ->
        raceUpdateTrack(cars, generateNumber, isMovable) // -> After merge it's solved.
        outputRoundResult(cars, eachRound + 1) // → Implement later on Output Module.
    }
    outputFinalWinner(cars) // → Implement later on Output Module.
}