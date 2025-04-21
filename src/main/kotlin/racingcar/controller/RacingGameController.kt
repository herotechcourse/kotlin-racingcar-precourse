package racingcar.controller

import camp.nextstep.edu.missionutils.Console
import racingcar.domain.Car
import racingcar.domain.Cars
import racingcar.domain.RacingGame
import racingcar.view.InputView
import racingcar.view.OutputView

/**
 * Racing game controller
 */
class RacingGameController {
    private val inputView = InputView()
    private val outputView = OutputView()

    /**
     * Runs the game
     */
    fun run() {
        val carNames = inputView.readCarNames()
        val rounds = inputView.readRounds()
        
        val cars = createCars(carNames)
        val game = RacingGame(cars, rounds)
        
        val results = game.race()
        outputView.printResults(results)
        
        val winners = game.getWinners()
        outputView.printWinners(winners)
    }

    /**
     * Creates car list
     * @param carNames List of car names
     * @return Cars object containing all cars
     */
    private fun createCars(carNames: List<String>): Cars {
        val cars = carNames.map { name -> Car(name) }
        return Cars(cars)
    }
} 