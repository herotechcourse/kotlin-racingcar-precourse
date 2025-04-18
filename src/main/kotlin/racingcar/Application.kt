package racingcar

fun main() {
    val cars = readCars()
    val rounds = readRounds()
    println()
    race(cars, rounds)
}
