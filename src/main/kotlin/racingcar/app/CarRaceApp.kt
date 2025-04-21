package racingcar.app

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import racingcar.game.RaceGame
import racingcar.player.Car
import racingcar.util.CarRaceUtil
import racingcar.util.InputValidator

class CarRaceApp(
    private val moveThreshold: Int, private val numberGenerator: () -> Int
) {
    private val raceGame = RaceGame<Car>()
    private val carRaceUtil = CarRaceUtil()

    fun play() {
        val validator = InputValidator()
        val raceWinCondition: (Car) -> Boolean = { this.numberGenerator() >= this.moveThreshold }
        val playRaceRound = raceGame.playRound(raceWinCondition) { it.copy(win = it.win + 1) }
        val simulateRaceRounds = raceGame.simulateRounds()
        val findRaceWinners = raceGame.findWinners()

        val cars = carRaceUtil.readCars({ Console.readLine() }) { validator.validateCars(it) }
        val rounds = carRaceUtil.readRounds({ Console.readLine() }) { validator.validateRounds(it) }

        val simulateResult = simulateRaceRounds(rounds, cars, playRaceRound)
        val winners = findRaceWinners(simulateResult.last()) { it.win }

        carRaceUtil.printRaceResult(simulateResult, winners)
    }


}