package racingcar

import racingcar.model.RacingGame
import racingcar.service.getCarNames
import racingcar.service.getNumberOfRounds
import racingcar.service.createCars

fun main() {
    val carNames = getCarNames()
    val cars = createCars(carNames)
    val numberOfRounds = getNumberOfRounds()
    val game = RacingGame(cars, numberOfRounds)
    game.startGame()
}