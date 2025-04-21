package racingcar

import racingcar.model.Car
import racingcar.io.InputHandler
import racingcar.model.RacingGame

fun main() {
    val inputHandler = InputHandler()
    val carNames = inputHandler.getCarNames()
    val rounds = inputHandler.getRounds()
    
    val cars = carNames.map { Car(it) }
    
    val racingGame = RacingGame(cars, rounds)
    racingGame.startRace()
}
