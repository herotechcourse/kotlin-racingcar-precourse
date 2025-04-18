package racingcar.controller

import racingcar.domain.Cars
import racingcar.domain.Referee
import racingcar.domain.Round
import racingcar.domain.car.Car
import racingcar.domain.car.Name
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingController(
    private val inputView: InputView,
    private val outputView: OutputView
) {
    fun run() {
        val cars = initCars()
        val round = initRound()
        playRace(round, cars)
        determineWinner(cars)
    }

    private fun initCars(): Cars {
        val carNames = inputView.readCarNames()

        val cars = carNames.map { Name(it) }
            .map { Car(it) }
            .toList()
        return Cars(cars)
    }

    private fun initRound(): Round {
        val totalRounds = inputView.readTotalRounds()

        val round = Round(totalRounds)
        return round
    }

    private fun playRace(round: Round, cars: Cars) {
        while (round.isRemaining()) {
            moveCars(cars)
            round.decrement()
        }
    }

    private fun moveCars(cars: Cars) {
        cars.moveAll()
        outputView.printEachRound(cars)
    }

    private fun determineWinner(cars: Cars) {
        val referee = Referee(cars)
        val winner = referee.determineWinner()
        outputView.printWinner(winner)
    }
}
