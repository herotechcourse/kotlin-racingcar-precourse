package racingcar

import racingcar.model.Cars
import racingcar.service.CarRace
import racingcar.view.GameView

fun main() {

    val carNames = GameView.readCarNames()
    val rounds = GameView.readRounds()

    val cars = Cars.from(carNames)
    val carRace = CarRace(cars)

    repeat(rounds){
        carRace.playRaceRound()
        GameView.printCarResult(cars.getCars())
    }

    val winners = cars.findWinners()
    GameView.printWinners(winners)

}
