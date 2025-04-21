package racingcar

fun main() {
    val carNames = getValidCarNames()
    val roundCount = getValidRoundCount()

    val car = Car(carNames[0])
    car.moveForward()
    car.moveForward()
    println("Position after 2 moves: ${car.getPosition()}")

//    println("Car Names: ${carNames.joinToString(", ")}")
}
