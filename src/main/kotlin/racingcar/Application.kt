package racingcar

fun main() {
    val carNames = UserInput.getCarNames()
    val rounds = UserInput.getNumberOfRounds()

    val cars = carNames.map { Car(it) }
}
