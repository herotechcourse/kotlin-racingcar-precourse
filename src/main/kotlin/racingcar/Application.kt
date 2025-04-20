package racingcar

import racingcar.core.CarRaceGame
import racingcar.utlls.CarFactoring
import racingcar.utlls.InputView
import racingcar.utlls.ResultView

fun main() {

    val carNamesInput = InputView.readCarNamesInput()
    val carsNames = InputView.parseCarNamesInput(carNamesInput)
    val carsList = CarFactoring.createCars(carsNames)

    val numberRounds = InputView.readAndParseRoundCountInput()

    val carRaceGame = CarRaceGame(carsList)

    println("\nRace Result")
    repeat(numberRounds) {
        carRaceGame.playOneRound()
        ResultView.displayEndPositions(carsList)
        println()
    }

    val winners = carRaceGame.getWinners()
    ResultView.printFinalWinners(winners)

}


