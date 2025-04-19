package racingcar.gameflow

import racingcar.model.Car
import racingcar.output.OutputModule
import racingcar.raceexecution.raceUpdateTrack

/**
 *  Controls the racing loop
 *  Updates car position and print result using the output module.
 */
fun gameLoop(
    cars: List<Car>,
    nRounds: Int,
    output: OutputModule,
    generateNumber: () -> Int,
    isMovable: (Int) -> Boolean
) {
    repeat(nRounds) {
        raceUpdateTrack(cars, generateNumber, isMovable)
        output.outputEachRoundResult(cars)
        println()
    }
    output.outputFinalWinner(cars)
}