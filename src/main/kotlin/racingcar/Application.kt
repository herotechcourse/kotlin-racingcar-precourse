package racingcar

import camp.nextstep.edu.missionutils.Console
import racingcar.domain.RacingGame
import racingcar.model.Car
import racingcar.util.getCarNames
import racingcar.util.createCars
import racingcar.util.getNumberOfRounds

/**
 * Main function to start the racing car game.
 * Handles user input for car names and number of rounds, and initiates the game.
 */
fun main() {
    val carNames = getCarNames()
    val cars = createCars(carNames)
    val rounds = getNumberOfRounds()

    val game = RacingGame(cars, rounds)
    game.startRace()
}
