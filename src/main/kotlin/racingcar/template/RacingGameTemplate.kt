package racingcar.template

import racingcar.Car
import racingcar.RacingGame
import racingcar.generator.RandomNumberGenerator

abstract class RacingGameTemplate(private val racingGame: RacingGame, private val round: Int) {

    fun execute(randomGenerator: RandomNumberGenerator) {
        printStartMessage()
        repeat(round) {
            racingGame.startGame(randomGenerator)
            printGame(racingGame.cars)
        }
        printWinner(racingGame.findWinner())
    }

    abstract fun printStartMessage()
    abstract fun printGame(cars: List<Car>)
    abstract fun printWinner(cars: List<Car>)

}