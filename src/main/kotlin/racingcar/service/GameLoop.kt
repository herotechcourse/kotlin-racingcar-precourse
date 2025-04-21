package racingcar.service

import racingcar.model.Car
import racingcar.view.OutputModule
import racingcar.service.raceexecution.raceUpdateTrack

/**
 *  Controls the racing loop
 *  Updates car position and print result using the output module.
 *
 *  [ Why did wrap moveCars() with raceUpdateTrack()? ]
 *  Wrapped moveCars() inside raceUpdateTrack() to express the game flow more clearly.
 *  While moveCars() handles the mechanics of moving each car,
 *  raceUpdateTrack() represents the progress of a round in the game loop.
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