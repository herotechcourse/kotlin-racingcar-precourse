package racingcar

fun main() {
    val names = InputView.readCarNames()
    val rounds = InputView.readRoundCount()
    val cars = names.map {Car(it)}
    println()

    println("Race Results")
    Racing(cars, rounds).play()

    val maxPosition = cars.maxOfOrNull { it.position } ?: 0
    val winners = cars.filter { it.position == maxPosition }.map { it.name }
    print("Winners : ${winners.joinToString (", ")}")
}
