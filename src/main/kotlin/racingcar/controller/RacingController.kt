package racingcar.controller

import racingcar.domain.Cars
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
        val carNames = getCarNames()
        val cars = createCars(carNames)
        val round = getRound()
        while (round.isRemaining()) {
            moveCars(cars)
            round.decrement()
        }
        val winner = cars.drawWinner()
    }

    private fun getCarNames(): List<Name> {
        val carNames = inputView.readCarNames()

        val names = carNames.split(",")
            .map { Name(it) }
            .toList()
        return names
    }

    private fun createCars(names: List<Name>) = Cars(
        names.stream()
            .map { createCar(it) }
            .toList())

    private fun createCar(it: Name) = Car(it)

    private fun getRound(): Round {
        val totalRounds = inputView.readTotalRounds()

        val round = Round(totalRounds)
        return round
    }

    private fun moveCars(cars: Cars) {
        cars.moveCar()
        outputView.printEachRound(cars)
    }
}
