package racingcar

import racingcar.utils.InputUtils

fun main() {
    // Make sure program runs with Kotlin 1.9.24 - TODO: delete before submission
    print("Kotlin version: ")
    println(KotlinVersion.CURRENT)

    val carNames = InputUtils.readCarNames()
    println("carNames: $carNames") // TODO: delete before submission

    val rounds = InputUtils.readRounds()
    println("rounds: $rounds") // TODO: delete before submission
}
