package racingcar

fun main() {
    // test
    val names = InputView.readCarNames()
    val rounds = InputView.readRoundCount()
    val cars = names.map {Car(it)}
    Racing(cars, rounds).play()

    println("car names: $names")
    println("rounds: $rounds")
}
