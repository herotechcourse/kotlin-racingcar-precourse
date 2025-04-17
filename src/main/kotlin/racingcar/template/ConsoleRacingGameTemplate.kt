package racingcar.template

import racingcar.Car
import racingcar.RacingGame
import racingcar.io.Output

class ConsoleRacingGameTemplate(racingGame: RacingGame) : RacingGameTemplate(racingGame) {

    override fun printStartMessage() {
        Output.printStartMessage()
    }

    override fun printGame(cars: List<Car>) {
        Output.printGame(cars)
    }

    override fun printWinner(cars: List<Car>) {
        Output.printWinner(cars)
    }

}