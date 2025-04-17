package racingcar.controller

import racingcar.domain.Cars
import racingcar.domain.Round
import racingcar.domain.car.Car
import racingcar.domain.car.Name
import racingcar.view.InputView

class RacingController {

    private val inputView = InputView()

    fun run() {
        val carNames = getCarNames()
        val cars = createCars(carNames)
        val round = getRound()
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
}
