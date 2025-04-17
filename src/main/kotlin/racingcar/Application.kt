package racingcar

fun main() {

    val carNamesInput = InputView.readCarNamesInput()
    val carsNames = InputView.parseCarNamesInput(carNamesInput)
    val carsList = CarFactoring.createCars(carsNames)

    val numberRounds = InputView.readAndParseRoundCountInput()

    val game = Game(carsList)

    println("\nRace Result")
    repeat(numberRounds) {
        game.play()
        ResultView.displayEndPositions(carsList)
        println()
    }

    val winners = game.getWinners()
    ResultView.printFinalWinners(winners)

}


