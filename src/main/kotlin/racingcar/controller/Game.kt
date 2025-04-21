package racingcar.controller

import racingcar.view.InputModule
import racingcar.view.OutputModule
import racingcar.service.raceexecution.generateRandomNumber
import racingcar.service.raceexecution.isMoveConditionMet
import racingcar.service.gameInit
import racingcar.service.gameLoop

/**
 *  [ Lambdas ]
 *  These delay the execution of generateRandomNumber() and isMoveConditionMet() logic until each round.
 *
 *  Difference between normal value and lambda
 *  val num = generateRandomNumber()            // executed immediately, once.
 *  val generate = { generateRandomNumber() }   // executed every time it's called, generate().
 */
class Game(private val input: InputModule,
            private val output: OutputModule) {
    fun start() {
        // 1. Getting input from User and save it.
        val inputHandler = GameConfigurator(input)   // Just holding the remote control.
        val gameConfig = inputHandler.configure()   // Press the remote control.

        // 2. Initialize game
        val initResult = gameInit(gameConfig)
        val listCars = initResult.cars
        val nRounds = initResult.rounds

        // 3. Set movement condition and randomness with Lambdas.
        val generate = { generateRandomNumber() }
        val isMovable = { number: Int -> isMoveConditionMet(number) }

        // 4. Start game
        println("\nRace Results")
        gameLoop(listCars, nRounds, output, generate, isMovable)
    }
}