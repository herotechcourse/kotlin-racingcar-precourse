package racingcar


fun main() {
    OutputController.printNamesOfCars()
    val nameOfCars = InputController.readNamesOfCars()

    OutputController.printPlayerRound()
    val limitRound = InputController.readRounds()

    val carRacingGame = CarRacingGame(nameOfCars, limitRound)
    carRacingGame.gameProcess()


}