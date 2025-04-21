package racingcar

import racingcar.getValidCarNames
import racingcar.getValidRoundCount

fun main() {
    val carNames = getValidCarNames()
    val roundCount = getValidRoundCount()

    println("Car Names: ${carNames.joinToString(", ")}")
    println("Racing Round: $roundCount Round")
}
