package racingcar

fun main() {

    val carNamesInput = InputView.readCarNamesInput()
    val carsNames = InputView.parseCarNamesInput(carNamesInput)
    val carsList = CarFactoring.createCars(carsNames)

    val numberRounds = InputView.readAndParseRoundCountInput()

    GameLogic(carsList, numberRounds).play()

}


