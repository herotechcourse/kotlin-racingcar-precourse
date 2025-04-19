package racingcar

fun main() {

    val carNamesInput = InputView.readCarNamesInput()
    val carsNames = InputView.parseCarNamesInput(carNamesInput)
    val carsList = CarFactoring.createCars(carsNames)

    val numberRounds = InputView.readAndParseRoundCountInput()

    val carRaceGame = CarRaceGame(carsList)

    println("\nRace Result")
    repeat(numberRounds) {
        carRaceGame.play()
        ResultView.displayEndPositions(carsList)
        println()
    }

    val winners = carRaceGame.getWinners()
    ResultView.printFinalWinners(winners)

}


