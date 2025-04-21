package racingcar

fun main() {
    val names = InputView.readCarNames()
    val rounds = InputView.readRoundCount()
    val cars = names.map {Car(it)}
    println()

    println("Race Results")
    Racing(cars, rounds).play()

    ResultView.printWinners(cars)
}
