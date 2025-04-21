package racingcar

fun main() {
    val inputParser = InputParser()
    val carNames = inputParser.getCarNames()
    val rounds = inputParser.getRounds()
    CarRacing().race(carNames, rounds)
}
